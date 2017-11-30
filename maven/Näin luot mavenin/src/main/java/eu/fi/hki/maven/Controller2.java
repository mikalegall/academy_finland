package eu.fi.hki.maven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//@Controller
public class Controller2 {


    @Autowired
    JdbcTemplate jdbc;

    @RequestMapping("/mysli")
    public String tokajdbctesti(Model model) {

//        List<String> kyselynTulos = jdbc.queryForList("SELECT * FROM country", String.class);

        List<ValtioToObject> kyselynTulos = jdbc.query("SELECT * FROM country",
                new RowMapper<ValtioToObject>() {
                    public ValtioToObject mapRow(ResultSet tulosjoukko, int indeksi)
                            throws SQLException {
                        ValtioToObject valtio = new ValtioToObject(
                                tulosjoukko.getString("continent"),
                                tulosjoukko.getString("name"),
                                tulosjoukko.getString("lifeexpectancy"));
                        return valtio;
                    }
                }
        );

        model.addAttribute("mysli", kyselynTulos);

        return "sqlsivu";
    }


}


