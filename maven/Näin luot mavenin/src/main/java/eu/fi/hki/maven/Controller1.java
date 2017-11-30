package eu.fi.hki.maven;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Controller1 {

    private static final Logger log = LoggerFactory.getLogger(Kontrolleri.class);
    JdbcTemplate jdbcTemplate;

    public Kontrolleri(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE customers(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

        // Split up the array of whole names into an array of first/last names
        List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        // Use a Java 8 stream to print out each tuple of the list
        splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);
    }

    @RequestMapping("/jdbc")
    public String ekajdbctesti(Model model) {
        log.info("Querying for customer records where first_name = 'Josh':");
        List<Customer> palautettu =
                jdbcTemplate.query(
                        "SELECT id, first_name, last_name FROM customers WHERE first_name = ? or first_name = ?",
                        new Object[]{"Josh", "Jane"},
                        new RowMapper<Customer>() {
                            @Override
                            public Customer mapRow(ResultSet rs, int i) throws SQLException {
                                return new Customer(rs.getLong("id"),
                                        rs.getString("first_name"),
                                        rs.getString("last_name"));
                            }
                        }
//                (ResultSet rs, int rowNum) ->
//                        new Customer(rs.getLong("id"),
//                                rs.getString("first_name"),
//                                rs.getString("last_name"))
                );
        palautettu.forEach(customer -> log.info(customer.toString()));
        model.addAttribute("nimi", "Josh");
        model.addAttribute("asiakkaat", palautettu);
        return "jdbcsivu";
    }

}
