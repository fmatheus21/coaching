/* global checkboxElem, KTApp */

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


function loadDelete(id) {
    document.getElementById("id-delete").innerHTML = id;
}

function consultCoachee(id) {

    let url = '/api/coachees/' + id;
    let xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status = 200) {
                console.log(JSON.parse(xhr.responseText));
                fillCoachee(JSON.parse(xhr.responseText));
            }
        }
    }
    xhr.send();

}

function fillCoachee(json) {
    console.log(json.casualName);
    document.getElementById('parameter').value = json.id;
    document.getElementById('parameterModal').innerHTML = json.id;
    document.querySelector('input[name="casualName"]').value = json.casualName;
    document.querySelector('input[name="name"]').value = json.name;
    document.querySelector('input[name="document"]').value = json.cpf;
    document.querySelector('input[name="gender"]').value = json.gender;
    document.querySelector('input[name="dateBirth"]').value = json.dateBirth;
    document.querySelector('input[name="email"]').value = json.email;
    document.querySelector('input[name="phone"]').value = json.phone;
    document.getElementById('editar').href = "/coachees/update/" + json.id;
    document.getElementById('registroSessao').href = "/coachees/" + json.id + "/session/reader";
    document.getElementById('avaliacao').href = "/coachees/" + json.id + "/assessments/reader";
}

function deleteCoachee(parameter) {
    var id = parameter.value;
    $('#modalConfirmDelete').modal('hide');
    KTApp.blockPage({
        overlayColor: '#000000',
        type: 'v2',
        state: 'success',
        size: "lg",
        message: 'Por favor, aguarde...'
    });
    setTimeout(function () {
        let form = document.createElement('form');
        form.action = '/coachees/delete/' + id;
        form.method = 'POST';
        document.body.append(form);
        form.submit();
    }, 10);
}

function createCycle(parameter) {
    var id = parameter.value;
    console.log(id);
    var id = parameter.value;
    $('#modalNewCycle').modal('hide');
    KTApp.blockPage({
        overlayColor: '#000000',
        type: 'v2',
        state: 'success',
        size: "lg",
        message: 'Por favor, aguarde...'
    });
    setTimeout(function () {
        let form = document.createElement('form');
        form.action = '/coachees/' + id + '/cycle';
        form.method = 'POST';
        document.body.append(form);
        form.submit();
    }, 10);
}









