package yoga.kulatantra;

import java.util.ArrayList;
import java.util.List;

public class InitResponse {

	static List<ReplieAnswer> createReplies() {
		List<ReplieAnswer> answers = new ArrayList<>();
		ReplieAnswer r1 = new ReplieAnswer();
		r1.setResponseForString("Kaikesta tuosta huolimatta sanoisin, että kumottaessa painovoimaa muodostetaan tuki aina jollain tavalla. Joten esimerkiksi pitkittynyt hartiajännitys ei rentoudu ennen kuin alaselkä on vapautettu ja tuki voidaan muodostaa tarkoituksenmukaiseen paikkaan tarkoituksenmukaisella tavalla. Riippuen TELEGRAM_FirstName juuri sinun tilanteestasi saattaa olla, että ennen Hatha jooga asanaharjoituksien tekemisiä, tai niiden tueksi, voisi olla tarpeen varata nyt sähköpostiosoitteesta shala.relax@gmail.com itsellesi HT-X hoitotapaaminen ja kartoittaa sitä kautta tilannetta tarkemmin. Muista alennuskampanja 😊\r\n" + 
				"https://www.facebook.com/permalink.php?story_fbid=126499752415123&id=106964701035295\r\n" + 
				"Ja jos haluat vielä meilaamisen jälkeenkin jatkaa vaikka pienen hetken jutustelua, niin lähetä jokin valokuva ja katketaan sitten siitä!");
		r1.setResponseForPhoto("Under construction (coming soon), in the meanwhile you might wanna try text message me suomeksi (eka)");
		r1.setResponseForVideo("Tehot ei tässä laitteessa riitä videoihin. Saattaa olla paras jatkaa tästä siten, että ota vaikka kuvaruutukaappaus siitä videon oleellsimmasta kohdasta ja lähetä se minulle. Tai sitten ihan vaan joku muu random kuvakin, niin tunnustelen nouseeko siitä jotain esiin tässä hetkessä");
		r1.setResponseForDocument("Oho, lähetit varmaan jotain tiedostomuodossa, mutta koska en saa sitä avattua voisit ehkä muutamalla sanalla kertoa mitä sen avaamisesta olisi minulle seurannut ja miten olisin sinuun sen jälkeen suhtautunut?");
		answers.add(r1);

		ReplieAnswer r2 = new ReplieAnswer();
		r2.setResponseForString(
				"TELEGRAM_FirstName, ottaen huomioon, että ihminen on kokonaisuus eikä meillä tietyllä tapaa ole erillistä mieltä ja kehoa vaan ilmentymä on erottomattomasti yhdessä, niin lähtisin kyllä purkamaan tätä kaikkea niin sanotusti top down menetelmällä. Eli varaa vaikka nyt ensin sähköpostiosoitteesta shala.relax@gmail.com itsellesi hoitotapaaminen joogahierontaan ja kartoitetaan tilannetta sitten sen jälkeen tarkemmin. Muista alennuskampanja 😊\r\n"
						+ "https://www.facebook.com/permalink.php?story_fbid=126499752415123&id=106964701035295\r\n" + 
						"Ja jos haluat vielä meilaamisen jälkeenkin jatkaa vaikka pienen hetken jutustelua, niin lähetä jokin valokuva ja katketaan sitten siitä!");
		r2.setResponseForPhoto("Under construction (coming soon), in the meanwhile you might wanna try text message me suomeksi (toka)");
		r2.setResponseForVideo("Hei, laita jotain muuta kuin videoita. Kerro vaikka mitä odotat saapuessasi Shala:an, mikä on hyvinvointihoidon tai asanaharjoituksen intentio?");
		r2.setResponseForDocument("Ei auennut. Oli varmaan tiedostomuodossa...  Mitä odotit, että siitä olisi seurannut?");
		answers.add(r2);

		ReplieAnswer r3 = new ReplieAnswer();
		r3.setResponseForString(
				"Hmmm, hetken tuota pähkäiltyäni totean, että vaikka tämä kaikki Shala Relax toiminta rakentuukin Hatha jooga asanaharjoituksiin olemme me nyt tilanteessa, jossa \"Present is the gateway to the future and the past\". Voidaan siis ajatella, että saavuit Shalaan, jossa joogamatolle kiipeäminen etenee\r\n"
						+ "1. lihaksen palauttamisella lepopituuteen (HT-X),\r\n"
						+ "2. pehmytkudoksen tukoksien poistamisella, joka johtaa virtausten esteettömyyteen (joogahieronta),\r\n"
						+ "3. painovoiman kumoamisella tarkoituksenmukaisella kehonhallinnalla ja siten minimienergialla (yksilöllinen asanaohjaus kotona harjoiteltavaksi ja tutustumis- sekä peruskurssit),\r\n"
						+ "4. kehon eri onteloiden painetta vaihtelemalla ja hermostoa rauhoittamalla, joka edesauttaa palautumista tasapainoon (määrämuotoiset asanasarjat viikkotunteina).\r\n\r\n"
						+ "Pysähdy TELEGRAM_FirstName ja kuuntele, mikä on sinun tilanteesi juuri tässä hetkessä. Ja varaa sen mukainen aika sähköpostiosoitteesta shala.relax@gmail.com ennen kuin kaikki kiire taas täyttää mielenmaiseman. Muista alennuskampanja 😊\r\n"
						+ "https://www.facebook.com/permalink.php?story_fbid=126499752415123&id=106964701035295\r\n" + 
						"Ja jos haluat vielä meilaamisen jälkeenkin jatkaa vaikka pienen hetken jutustelua, niin lähetä jokin valokuva ja katketaan sitten siitä!");
		r3.setResponseForPhoto("Under construction (coming soon), in the meanwhile you might wanna try text message me suomeksi (kolmas)");
		r3.setResponseForVideo("Video vastaus puuttuu (kolmas)");
		r3.setResponseForDocument("Tiedosto vastaus puuttuu (kolmas)");
		answers.add(r3);

		return answers;
	}

}
