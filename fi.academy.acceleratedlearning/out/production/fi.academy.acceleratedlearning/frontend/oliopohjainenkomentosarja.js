// Pakotetaan muuttujan (variable) esittely tapahtuvaksi (var x = arvo;)
"use strict";


// KELLONAIKA ALKAA
// Luodaan muuttuja aika
var aika = new Date();
// Jos aikaa osoittava luku näytetään yksinumeroisena, niin lisää siihen nolla eteen
var tunnit = (aika.getHours() < 10) ? "0"+ aika.getHours() : aika.getHours();
var minuutit = (aika.getMinutes() < 10) ? "0"+ aika.getMinutes() : aika.getMinutes();
var sekuntit = (aika.getSeconds() < 10) ? "0"+ aika.getSeconds() : aika.getSeconds();

// Haetaan HTML-dokumentista käsiteltäväksi elementti, jonka ID on "neitiaika"
var neitiaika = document.getElementById("neitiaika");
// Lisätään käsiteltävänä olevaan elementtiin aika
neitiaika.innerHTML = "Tälle sivulle muuten tulostettiin kellonaika javascriptillä klo. " + tunnit + ":" + minuutit + "." + sekuntit;
// KELLONAIKA LOPPUU


// OTSIKKO PUDOTUSVALIKKONA (NÄYTÄ / PIILOTA -TOIMINTO) PELKÄLLÄ JAVASCRIPTILLÄ ALKAA
// function asetaKasittelijat() {
//     // Haetaan HTML-dokumentista kaikki H3-tason otsikkojen tagit käsiteltäväksi
//     // ja tallennetaan ne indeksoituun taulukkoon
//     var kaikki = document.getElementsByTagName("h3");
//
//     for (var i = 0 ; i < kaikki.length ; i++){
//         // Lisätään jokaiseen H3-tagiin tapahtuman käsittelijä (tässä tapauksessa
//         // saadaan selaimelta tieto osoittimen ykköspainikkeen napsautuksesta)
//         kaikki[i].onclick = piilota;   // Hiiren klikkauksesta kutsutaan metodia "piilota"
//     }
// }
//
//     // Käynnistetään metodi
//     asetaKasittelijat();
//
// function piilota(event) {
//     // Jos tapahtuman lähettäjän (H3-tag) näkökulmasta seuraava sisarustason elementti on piilotettuna...
//     if (event.target.nextElementSibling.style.display === "none") {
//
//         //... niin aseta se näkyväksi rivinvaihdollisena elementtinä ("inline" on ilman rivinvaihtoa)
//         event.target.nextElementSibling.style.display = "block";
//     }
//     else {
//         // Muutoin piilotetaan tapahtuman lähettäjän (H3-tag) näkökulmasta
//         // seuraava sisarustason elementti
//         event.target.nextElementSibling.style.display = "none";
//     }
// }
// OTSIKKO PUDOTUSVALIKKONA (NÄYTÄ / PIILOTA -TOIMINTO) PELKÄLLÄ JAVASCRIPTILLÄ LOPPUU


// JSON PARSINTA LIIKENNEVIRASTOSTA ALKAA
// Haetaan HTML-dokumentista haluttu elementti käsiteltäväksi
var htmlElementti = document.getElementById("lista");

// Luodaan XMLHttpRequest olio
var kyselija = new XMLHttpRequest();

// Alustetaan yhteys "true" -arvolla asynkroniseksi
kyselija.open("GET", "https://rata.digitraffic.fi/api/v1/live-trains/station/HKI/LR", true);
// Avataan yhteys
kyselija.send();

// Luodaan avoimelle yhteydelle (oliolle) tapahtumankäsittelijä,
// joka (tilanmuutosten yhteydessä) toteuttaa kommunikointia metodilla
kyselija.onreadystatechange = function () {
    if (kyselija.readyState === 4) {
        if (kyselija.status === 200 || kyselija.status === 204) {

            // Mikäli tähän Jos-lauseeseen on astuttu, niin pyyntö on valmis
            // console.log(kyselija.responseText);

            // Tallennetaan saatu vastausteksti erilliseen muuttujaan
            // ihan vaan selkeyden vuoksi ja siis esimerkin omaisesti
            var sisalto = kyselija.responseText;

            // Muunnetaan saatu merkkijono (String) taulukoksi, jäsentelemällä (parse)
            // sen aaltosulkeissa olevat osuudet dynaamisesti kasvatettavan taulukon eri alkioiksi
            var taulu = JSON.parse(sisalto);

            // Selaimen kehittäjätyökalun konsolilla huomataan hakemistosta (dir)
            // kyseessä olevan Javan kaltainen HashMap-taulukko (JavaScriptin assosiatiivinen
            // avain-arvo -pari taulukko). Konsolilta nähdään mitä avaimia eri arvoille on tarjolla
            console.dir(taulu);


            for (var indexEka = 0 ; indexEka < taulu.length ; indexEka++){
                var junaTaulukkona = taulu[indexEka];

                var lahtoaika = new Date(junaTaulukkona.timeTableRows[0].scheduledTime);
                var stilisointi = {hour: "2-digit", minute: "2-digit", hour12: false};
                var taulukonKoko = junaTaulukkona.timeTableRows.length;
                var saapumisaika = new Date();  // Esitellään ennen seuraavaa silmukaa muuttuja, silmukan ulkopuolella

                // Java scriptissä ei voi käyttää ns. "fori"-silmukassa saman nimistä muuttujaa
                // kuin toisessa forissa; sen vuoksi nimeäminen indexEka ja indexToka
                for (var indexToka = 0 ; indexToka < junaTaulukkona.timeTableRows.length ; indexToka++){

                    if (junaTaulukkona.timeTableRows[indexToka].stationShortCode === "LR"){
                        saapumisaika = new Date(junaTaulukkona.timeTableRows[indexToka].scheduledTime);
                        // Pysäytetään silmukka ensimmäisellä kerralla ehtolauseeseen astuttaessa,
                        // koska seuraava saman pysäkin kellonaika on junan matkan jatkumisen aika
                        // eli lähtöaika samalta asemalta
                        break;
                    }
                }

// Luodaan elementtipuun rakenteeseen uusi tekstisolmu ja haetaan
// siihen sisältökirjoitusta
                 var solmu = document.createTextNode(junaTaulukkona.trainCategory + ' juna: "' + junaTaulukkona.trainType + junaTaulukkona.trainNumber +
                     '" (Helsingistä) lähtee klo. ' + lahtoaika.toLocaleTimeString("fi", stilisointi) + " ja saapuu Lappeenrantaan klo. " +
                     saapumisaika.toLocaleTimeString("fi", stilisointi));

// Jokaisella silmukoinnilla tehdään uusi kohta järjestämättömään listaan
                 var uusielementti = document.createElement("li");
// Jokaiseen listaelementin uuteen kohtaan sijoitetaan tekstisolmu,
// jossa on kirjoitusta taulukon sisällöstä
                 uusielementti.appendChild(solmu);

// Käsiteltävään HTML-elementtiin lisätään uusi
// osio listaelementin kohta, jossa on taulukosta
// haettu sisältö kapseloituna sisälleen tekstiNodeen,
// ikään kuin maatuskanuken tavoin...
                 htmlElementti.appendChild(uusielementti);

// HTML-sivun muokkaus olisi voitu tehdä myös suoraan, maatuskanuken tavoin, asettamalla lauseet sisäkkäin:
// htmlElementti.appendChild(document.createElement("li").appendChild(document.createTextNode(junaTaulukkona.trainCategory + ' juna: "' + junaTaulukkona.trainType + junaTaulukkona.trainNumber + '" (Helsingistä) lähtee klo. ' + lahtoaika.toLocaleTimeString("fi", stilisointi) + " ja saapuu Lappeenrantaan klo. " + saapumisaika.toLocaleTimeString("fi", stilisointi))));
            }
        } else {
                alert("Pyyntö epäonnistui");
          }
    }
}
// JSON PARSINTA LIIKENNEVIRASTOSTA LOPPUU

