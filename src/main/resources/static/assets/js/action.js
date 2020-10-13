/* global checkboxElem */

function changeSelectCoache() {
    var select = document.getElementById('coache');
    var option = select.options[select.selectedIndex];
    var value = option.value;

    if (value > 0) {
        console.log('Habilita componente');
        document.getElementById("checkbox_coache").disabled = false;

    }

    console.log(value);

    /*document.getElementById('value').value = option.value;
     document.getElementById('text').value = option.text;*/
}

function checkboxCoache(checkboxElem) {

    var select = document.getElementById('coache');
    var option = select.options[select.selectedIndex];

    if (checkboxElem.checked) {
        document.getElementById('nomeAvaliado').value = option.text;
        document.getElementById('emailAvaliado').value = 'contact@domain.com';
        document.getElementById('nomeAvaliado').disabled = true;
        document.getElementById('emailAvaliado').disabled = true;
    } else {
        document.getElementById('nomeAvaliado').value = '';
        document.getElementById('emailAvaliado').value = '';
        document.getElementById('nomeAvaliado').disabled = false;
        document.getElementById('emailAvaliado').disabled = false;
    }

}






