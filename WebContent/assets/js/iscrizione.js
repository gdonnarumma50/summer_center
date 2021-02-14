/*const controlForm = function control(obj) {
	
	switch(obj.id) {
		case "nome":
			var nome = document.getElementById("nome");
		    if( !/^[A-Za-z]{3,}$/.test(nome.value) ){
		    	nome.setAttribute("class","form-control is-invalid");
		    	$("#invalidNome").html("Il nome avere almeno 3 caratteri!");
		    }
		    else {
		    	nome.setAttribute("class","form-control is-valid");
		    }
		 break;
		 
		case "cognome":
			var cognome = document.getElementById("cognome");
		    if( !/^[A-Za-z]{3,}$/.test(cognome.value) ){
		    	cognome.setAttribute("class","form-control is-invalid");
		    	$("#invalidCognome").html("Il cognome deve avere almeno 3 caratteri!");
		    }
		    else {
		    	cognome.setAttribute("class","form-control is-valid");
		    }
		 break;
		 
		case "luogoNascita":
			var luogoNascita = document.getElementById("luogoNascita");
		    if( !/^[A-Za-z]{3,}$/.test(luogoNascita.value) ){
		    	luogoNascita.setAttribute("luogoNascita","form-control is-invalid");
		    	$("#invalidLuogoNascita").html("Il luogo di nascita deve avere almeno 3 caratteri!");
		    }
		    else {
		    	luogoNascita.setAttribute("class","form-control is-valid");
		    }
		 break;
		 
		case "dataNascita":
			const elementDataNascita = document.getElementById("dataNascita")
			var dataNascita = new Date(elementDataNascita.value);
			const dateAttuale = new Date();
			const eta = dateAttuale().getFullYear() - dataNascia.getFullYear();
			
		    if(eta && eta>= 18){
		    	elementDataNascita.setAttribute("dataNascita","form-control is-invalid");
		    	$("#invalidDataNascita").html("Il bambino è troppo grande per essere iscritto!");
		    }
		    else {
		    	elementDataNascita.setAttribute("class","form-control is-valid");
		    }
		 break;
		 
		case "codiceFiscale":
			var codiceFiscale = document.getElementById("codiceFiscale");
		    if( !/"^[a-zA-Z]{6}[0-9]{2}[abcdehlmprstABCDEHLMPRST]{1}[0-9]{2}([a-zA-Z]{1}[0-9]{3})[a-zA-Z]{1}$/.test(codiceFiscale.value) ){
		    	codiceFiscale.setAttribute("codiceFiscale","form-control is-invalid");
		    	$("#invalidCodiceFiscale").html("Codice Fiscale non valido!");
		    }
		    else {
		    	codiceFiscale.setAttribute("class","form-control is-valid");
		    }
		 break;
		 
		case "infoEsigenzeAlimentari":
			const infoEsigenzeAlimentari = document.getElementById("infoEsigenzeAlimentari");
			const esigenzeAlimentari = document.getElementById("esigenzeAlimentari");
		    if(esigenzeAlimentari.value && !infoEsigenzeAlimentari.value){
		    	infoEsigenzeAlimentari.setAttribute("infoEsigenzeAlimentari","form-control is-invalid");
		    	$("#infoEsigenzeAlimentari").html("Il campo è obbligatorio se il flag esigenze aliemntari è settato!");
		    }
		    else {
		    	infoEsigenzeAlimentari.setAttribute("class","form-control is-valid");
		    }
		 break;
			
	}
}*/

/*$(document).ready(function() {
	$('#form_iscrizione').on("submit", function(e) {
		let error_free = false;
		  var nome = document.getElementById("nome");
		    if( !/^[A-Za-z]{3,}$/.test(nome.value) ){
		    	nome.setAttribute("class","form-control is-invalid");
		    	$("#invalidNome").html("Il nome avere almeno 3 caratteri!");
		    	error_free = false;
		    }
		    if (!error_free){
				event.preventDefault(); 
			}
			else{
				alert('No errors: Form will be submitted');
			}
		    
		    return false;
	});
	      
	 
});*/
function onChangeBambino(event) {
	//Svuoto i campi se popolati
	const cf = document.getElementById("codiceFiscale");
	cf.value = "";
	if(cf.getAttribute("disabled")) {
		cf.removeAttribute("disabled")
	}
	
	const dataNascita = document.getElementById("dataNascita");
	dataNascita.value = "";
	dataNascita.disabled === true ? dataNascita.disabled = false : dataNascita.disabled = true;
	
	const luogoNascita = document.getElementById("luogoNascita");
	luogoNascita.value = "";
	if(luogoNascita.getAttribute("disabled")) {
		luogoNascita.removeAttribute("disabled")
	}
	
	const nome = document.getElementById("nome");
	nome.value = "";
	if(nome.getAttribute("disabled")) {
		nome.removeAttribute("disabled")
	}
	
	const cogn = document.getElementById("cognome");
	cogn.value = "";
	if(cogn.getAttribute("disabled")) {
		cogn.removeAttribute("disabled")
	}
	
	const disab = document.getElementById("disabilita");
	disab.checked = false;
	
	const genere = document.getElementById("genere");
	genere.value = "";
	genere.disabled === true ? genere.disabled = false : genere.disabled = true;
	
	const esigenze = document.getElementById("esigenze");
	esigenze.checked = false;
	const infoEsigenze = document.getElementById("infoEsigenze");
	infoEsigenze.value = "";
	const farmaci = document.getElementById("farmaci");
	farmaci.value = "";
	const allergie = document.getElementById("allergie");
	allergie.value = "";
	const taglia = document.getElementById("taglia");
	taglia.value = "";
	const materialeGal = document.getElementById("materialeGal");
	materialeGal.checked = false;
	
	//Nuovo Bambino
	const valueDefault = $("#bambini :selected").text();
	if(valueDefault === "") {
		return;
	}
	
	const cfSel = $("#bambini :selected").attr("data-CF");
	const dataNascitaSel = $("#bambini :selected").attr("data-nascita");
	const nomeSel = $("#bambini :selected").attr("data-nome");
	const cognomeSel = $("#bambini :selected").attr("data-cogn");
	const luogoNascitaSel = $("#bambini :selected").attr("data-luogoNascita");
	const disabilitaSel = $("#bambini :selected").attr("data-disabilita");
	const genereSel = $("#bambini :selected").attr("data-genere");
	
	const esigenzeSel = $("#bambini :selected").attr("data-esigenze");
	const infoEsigenzeSel = $("#bambini :selected").attr("data-infoEsigenze");
	const farmaciSel = $("#bambini :selected").attr("data-farmaci");
	const allergieSel = $("#bambini :selected").attr("data-allergie");
	const tagliaSel = $("#bambini :selected").attr("data-taglia");
	const materialeGalSel = $("#bambini :selected").attr("data-materialeGal");
	
	infoEsigenze.value = infoEsigenzeSel ? infoEsigenzeSel : "";
	farmaci.value = farmaciSel ? farmaciSel : "";
	
	allergie.value = allergieSel ? allergieSel : "";
	
	taglia.value = tagliaSel ? tagliaSel : ""; 
	
	esigenze.checked = esigenzeSel === 'true' ? true : false;
	
	materialeGal.checked = materialeGalSel === 'true' ? true :  false;
	
	disab.checked = disabilitaSel === 'true' ? true : false;
	
	cf.value = cfSel;
	cf.setAttribute("disabled", true);
	
	nome.value = nomeSel;
	nome.setAttribute("disabled", true);
	
	cogn.value = cognomeSel;
	cogn.setAttribute("disabled", true);
	
	
	luogoNascita.value = luogoNascitaSel;
	luogoNascita.setAttribute("disabled", true);
	
	genere.value = genereSel;
	genere.disabled = true;
	
	var dataDaFormattare = new Date(dataNascitaSel)
	dataNascita.value = dataDaFormattare.getFullYear() + "-"
	        + String(dataDaFormattare.getMonth() + 101).slice(-2) + "-"
	        + String(dataDaFormattare.getDate() + 100).slice(-2);
	dataNascita.disabled = true;
	
	
}

$(document).ready(function() {
    // Selezione form e definizione dei metodi di validazione
    $("#form_iscrizione").validate({
        // Definiamo le nostre regole di validazione
        rules : {
            nome : {
                required : true,
                'patternCommon': true
            },
            cognome : {
                required : true,
                'patternCommon': true
            },
            luogoNascita : {
                required : true,
                'patternCommon': true
            },
            codiceFiscale: {
            	required: true,
            	'patternCF': true
            }, 
            dataNascita: {
            	required: true,
            	date: true,
            	'validateEta': true
            }
        },
        // Personalizzimao i mesasggi di errore
        messages: {
            nome: {
                required: "Il campo è obbligatorio"
            },
            cognome: {
                required: "Il campo è obbligatorio"
            },
            codiceFiscale: {
                required: "Il campo è obbligatorio"
            },
            dataNascita: {
                required: "Il campo è obbligatorio"
            },
            esigenzeAlimentari: {
            	'esigenzeAlimentari': true
            },
            infoEsigenzeAlimentari: {
            	'infoEsigenzeAlimentari': true,
            }
        },
        // Settiamo il submit handler per la form
        submitHandler: function(form, event) {
        	const settimane = document.getElementsByName('settimane').length; 
        	const tipoSoggiorno = $("#tipoSoggiorno").value;
        	const disabilita = $("#disabilita").value;
        	const servizioSportivo = $("#servizioSportivo").value;
        	const prezzo = 0;
        	
        	if(tipoSoggiorno.toUppercase() === "PART-TIME") {
    			prezzo += 50*settimane;
    		} else {
    			prezzo += 100*settimane;
    		}
    		
    		if(disabilita) {
    			prezzo += 50*settimane;
    		}
    		
    		if(servizioSportivo) {
    			prezzo += 20;
    		}
    		
    		console.log(prezzo);
    		
    		event.stopPropagation();
        	
        	
          //form.submit();
        }
    });
    
    $.validator.addMethod('patternCommon', function(value, element) {
    	return /^[A-Za-z]{3,}$/.test(value);
    }, "Il campo deve contenere almeno 3 caratteri alfabetici!");
    
    $.validator.addMethod('patternCF', function(value, element) {
    	return /^[a-zA-Z]{6}[0-9]{2}[abcdehlmprstABCDEHLMPRST]{1}[0-9]{2}([a-zA-Z]{1}[0-9]{3})[a-zA-Z]{1}$/.test(value);
    }, "Il campo non è valido!");
    
    $.validator.addMethod('validateEta', function(value, element) {
    	const annoDiNascita = new Date(value).getFullYear();
    	const annoAttuale = new Date().getFullYear();
    	const eta = annoAttuale - annoDiNascita;
    	
    	return eta < 18;
    }, "Il bambino è troppo grande per essere iscritto!");
    
    $.validator.addMethod('infoEsigenzeAlimentari', function(value, element) {
    	const esigenze = $('#esigenzeAlimentari').value;
    	
    	if(!value && esigenze) {
    		return false;
    	}
    	
    	return true;
    }, "Il campo è obbligatore se il campo esigenze alimentari è selezionato!");
    
    $.validator.addMethod('esigenzeAlimentari', function(value, element) {
    	const info = $('#infoEsigenzeAlimentari').value;
    	
    	if(!value && info) {
    		console.log('ERROR');
    		return false;
    	}
    	
    	return true;
    }, "Il campo deve essere selezionato se la descrizione è presente");
});