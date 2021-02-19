$(document).ready(function() {
	document.getElementById("bambini").addEventListener('click',function onChangeBambino(event) {
		//Svuoto i campi se popolati
		const cf = document.getElementById("codiceFiscale");
		cf.value = "";
		if(cf.getAttribute("readonly")) {
			cf.removeAttribute("readonly")
		}
		
		const dataNascita = document.getElementById("dataNascita");
		dataNascita.value = "";
		if(dataNascita.getAttribute("readonly")) {
			dataNascita.removeAttribute("readonly")
		}
		
		const luogoNascita = document.getElementById("luogoNascita");
		luogoNascita.value = "";
		if(luogoNascita.getAttribute("readonly")) {
			luogoNascita.removeAttribute("readonly")
		}
		
		const nome = document.getElementById("nome");
		nome.value = "";
		if(nome.getAttribute("readonly")) {
			nome.removeAttribute("readonly")
		}
		
		const cogn = document.getElementById("cognome");
		cogn.value = "";
		if(cogn.getAttribute("readonly")) {
			cogn.removeAttribute("readonly")
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
		
		infoEsigenze.value = infoEsigenzeSel && infoEsigenzeSel !== 'null' ? infoEsigenzeSel : "";
		farmaci.value = farmaciSel && farmaciSel !== 'null' ? farmaciSel : "";
		
		allergie.value = allergieSel && allergieSel !== 'null' ? allergieSel : "";
		
		taglia.value = tagliaSel ? tagliaSel : ""; 
		
		esigenze.checked = esigenzeSel === 'true' ? true : false;
		
		materialeGal.checked = materialeGalSel === 'true' ? true :  false;
		
		disab.checked = disabilitaSel === 'true' ? true : false;
		
		cf.value = cfSel;
		cf.setAttribute("readonly", "readonly");
		
		nome.value = nomeSel;
		nome.setAttribute("readonly", "readonly");
		
		cogn.value = cognomeSel;
		cogn.setAttribute("readonly", "readonly");
		
		
		luogoNascita.value = luogoNascitaSel;
		luogoNascita.setAttribute("readonly", "readonly");
		
		genere.value = genereSel;
		genere.setAttribute("disabled",true);
		
		var dataDaFormattare = new Date(dataNascitaSel)
		dataNascita.value = dataDaFormattare.getFullYear() + "-"
		        + String(dataDaFormattare.getMonth() + 101).slice(-2) + "-"
		        + String(dataDaFormattare.getDate() + 100).slice(-2);
		dataNascita.setAttribute("readonly", "readonly");
	});
	
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
            },
            tipoSoggiorno: {
            	required: true
            },
            genere: {
            	required: true
            },
            settimane: {
            	required: true
            },
            documentoIdentita: {
            	'patternFile': true
            },
            certificatoMedico: {
            	required: true,
            	'patternFile': true
            },
            tagliaIndumenti: {
            	required: true
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
            },
            tipoSoggiorno: {
            	required: "Il campo è obbligatorio"
            },
            genere: {
            	required: "Il campo è obbligatorio"
            }, 
            settimane: {
            	required: "Il campo è obbligatorio"
            },
            documentoIdentita: {
            	required: "Il campo è obbligatorio"
            },
            certificatoMedico: {
            	required: "Il campo è obbligatorio"
            },
            tagliaIndumenti: {
            	required: "Il campo è obbligatorio"
            }
        },
        // Settiamo il submit handler per la form
        submitHandler: function(form, event) {
          form.submit();
        }
    });
    
    $.validator.addMethod('patternCommon', function(value, element) {
    	return /^[A-Za-z ]{3,}$/.test(value);
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
    		return false;
    	}
    	
    	return true;
    }, "Il campo deve essere selezionato se la descrizione è presente!");
    
    $.validator.addMethod('patternFile', function(value, element) {
    	return /([a-zA-Z0-9\s_\\.\-\(\):])+(.jpeg|.png|.pdf)$/.test(value);
    }, "Nome file non valido o estensione non consentita!");
});