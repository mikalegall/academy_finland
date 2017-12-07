import React, {Component} from 'react';
import SockJS from 'sockjs-client';

class App extends Component {

    state = {viestinteksti: ' '}
    onChange = () => {
        this.setState(lahetaViesti({viestinteksti: document.getElementById('live_editori').value}));
    }

    /*
        // Vaihtoehtoinen tapa vanhalla tyylillä
        constructor(props) {
            super(props);
        this.state = {viestinteksti: ' '}
        this.onChange = this.onChange.bind(this);
        }
        onChange() { lahetaViesti(this.setState({viestinteksti: !this.state.viestinteksti})); }
    */

    render() {

        return (
            <div className="App">

                <center>
                    <form>
                        <fieldset>
                            <legend>Online editor</legend>
                            <div>
                                <label>Live chat</label>
                                <div>

                                    <textarea id="live_editori" rows="35" cols="150" placeholder={"Kirjoita tähän..."}
                                              onChange={this.onChange}
                                    ></textarea>

                                </div>
                            </div>

                        </fieldset>
                    </form>
                </center>

            </div>
        );
    }
}

var stompProtokollanAsiakasTilaaja = null;

function connect() {

    /* <!-- https://www.npmjs.com/package/http-proxy#proxying-websockets  --> */
    var yhteysosoiteWebSocketillaNetissa = new SockJS("http://localhost:8080/rekisteroidy");

    /* <!-- <script src="http://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script> --> */
    stompProtokollanAsiakasTilaaja = window.Stomp.over(yhteysosoiteWebSocketillaNetissa);

    /* Avataan yhteys netissä olevaan pistokkeeseen (webSocket) */
    stompProtokollanAsiakasTilaaja.connect({}, function (frame) {
        console.log('Yhdistetty: ' + frame);

        /* Yhteyden avauduttua rekisteröidytään tilaajaksi pistokkeen (WebSocket) viestilähetyksille */
        stompProtokollanAsiakasTilaaja.subscribe('/keskustelunaihe_ulos/viestisanoma',
            naytaNettisivullaKaikilleJonkunViesti);
        });
}

connect();

function lahetaViesti(parametripotko) {
    var nettiNapyttelyt = parametripotko.viestinteksti;
    stompProtokollanAsiakasTilaaja.send("/pistoke/viestit_sisaan", {},
        JSON.stringify({'viestinteksti': nettiNapyttelyt}));
    console.log("Lähetetty palvelimelle onnistuneesti: '" + nettiNapyttelyt + "'")
}

/*function lahetaViesti() {
    // var nettiNapyttelyt = document.getElementById('live_editori').value;
    var nettiNapyttelyt = this.state;
    window.stompProtokollanAsiakasTilaaja.send("/pistoke/viestit_sisaan", {},
        JSON.stringify({'viestinteksti': nettiNapyttelyt}));
}*/


function naytaNettisivullaKaikilleJonkunViesti(sanoma) {
    console.log(sanoma.body);
    var viesti = JSON.parse(sanoma.body);
    console.log('Viesti vastaanotettu: ' + viesti.viestinteksti);
    document.getElementById('live_editori').value = viesti.viestinteksti;
}

export default App;