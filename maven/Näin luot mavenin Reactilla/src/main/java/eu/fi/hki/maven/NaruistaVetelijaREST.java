package eu.fi.hki.maven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


// Tarjotaan REST-rajapinta esim. React:ille
// https://spring.io/guides/tutorials/react-and-spring-data-rest/
@RestController
public class NaruistaVetelijaREST {

    @Autowired
    private SanontaRepository lausahdusrepo;

    // R(ead) GET: Haku
/*
    @RequestMapping(value = "rajapinta/mietelause", method = RequestMethod.GET)  <-- Jäljempänä oleva @GetMapping (uudempi tapa) korvaa tämän
    @ResponseBody <-- tuota ei tarvita, koska aiemmin on ilmeoitettu @RestController, joka sisältää sekä @Controller että @ResponseBody
*/
    @GetMapping("rajapinta/mietelause")
    public Iterable<Sanonta> haeKaikkiSanonnat() {

        return lausahdusrepo.findAll();
    }

    @GetMapping("rajapinta/mietelause/{id}")
    public Sanonta haeTiettySanonta(@PathVariable Integer id) {

        return lausahdusrepo.findOne(id);
    }


    // C(reate) POST: Uuden tiedon syöttö
/*
    @RequestMapping(value = "rajapinta/mietelause", method = RequestMethod.POST)  <-- Jäljempänä oleva @PostMapping (uudempi tapa) korvaa tämän
*/
    @PostMapping("rajapinta/mietelause")
    public void lisaaYksiSanonta(@RequestBody Sanonta lausahdus) {

        lausahdusrepo.save(lausahdus);
    }


    // U(pdate) PUT: Päivitys
    @PutMapping("rajapinta/mietelause/{id}")
    public void paivitaYhtaSanontaa(@PathVariable("sanontaId") int id, @RequestBody Sanonta lausahdus) {
//
//        sanonta.id = id;
//Tai poista se rivi (olio) mikä saatiin id:llä ja tuuppaa usi sisään samalla id:llä

 /*       Sanonta olemassaoleva = lausahdusrepo.findOne(id);
        olemassaoleva = lausahdus;
        lausahdusrepo.(olemassaoleva);
 */   }





/*
    // D(elete) DELETE: Poisto
    @DeleteMapping("/mietelause")
    public ResponseEntity poistaSanonta(@PathVariable("sanontaId") int id) {

        return x;
    }

*/


********************************************************************************************************************************************************


    @PutMapping("/sanonnat/{id}")
    public ResponseEntity<Sanonta> muutasanontaa(@PathVariable(name = "id") int id, @RequestBody Sanonta sanonta) {
        if(!sanontaRepository.exists(id)) {
            return ResponseEntity.notFound().build();
        }
        sanonta.paivitaTiedot(sanonta);
        sanontaRepository.save(sanonta);
        return ResponseEntity.ok(sanonta);
    }

	
	
	
    @PostMapping("/sanonnat")
    public ResponseEntity luosanonta(@RequestBody Sanonta sanonta) throws URISyntaxException {
        sanonta.aloitaHistoria();
        sanontaRepository.save(sanonta);
        URI location = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(8080)
                .path("api/sanonnat/{id}")
                .buildAndExpand(sanonta.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

	
	
    @DeleteMapping("/sanonnat/{id}")
    public ResponseEntity<String> poistasanonta(@PathVariable(name="id") int id) {
        sanontaRepository.delete(id);
        return ResponseEntity.ok().build();
    }

	    @DeleteMapping("/sanonnat")
    public ResponseEntity poistakaikki() {
        sanontaRepository.deleteAll();
        return ResponseEntity.ok().build();
    }

	
	    @GetMapping("reset")
    public ResponseEntity<Iterable<Sanonta>> alustaSanonnoilla() {
        sanontaRepository.deleteAll();
        Sanonta s = new Sanonta("The difference between stupidity and genius is that genius has its limits.", "Albert Einstein");
        sanontaRepository.save(s);
        sanontaRepository.save(new Sanonta("A common mistake that people make when trying to design something completely foolproof is to underestimate the ingenuity of complete fools.", "Douglas Adams"));
        sanontaRepository.save(new Sanonta("Do, or do not. There is no 'try'.", "Yoda"));
        sanontaRepository.save(new Sanonta("Make everything as simple as possible, but not simpler.", "Albert Einstein"));
        sanontaRepository.save(new Sanonta("Copy from one, it's plagiarism; copy from two, it's research.", "Wilson Mizner"));
        sanontaRepository.save(new Sanonta("People think computers will keep them from making mistakes. They're wrong. With computers you make mistakes faster.", "Adam Osborne"));
        sanontaRepository.save(new Sanonta("Any sufficiently advanced technology is indistinguishable from magic.", "Arthur C. Clarke"));
        sanontaRepository.save(new Sanonta("Poor is the pupil who does not surpass his master.", "Leonardo da Vinci"));
        URI location = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(8080)
                .path("api/sanonnat")
                .build()
                .toUri();

        return ResponseEntity.created(location).body(sanontaRepository.findAll());
    }

	
}
