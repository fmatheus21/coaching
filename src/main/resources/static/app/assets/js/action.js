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

    document.getElementById("timeline-items").innerHTML = '';
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
    document.getElementById("buttonNewCycle").disabled = json.buttonNewCycle;

    if (json.listCycleGenerateDto.length > 0) {

        $.each(json.listCycleGenerateDto, function (idx, value) {
            var newdiv = $(
                    `<div class="timeline-item">
                 <div class="timeline-media">
                 <i class="flaticon2-layers text-primary"></i>
                 </div>
                 <div class="timeline-content">
                 <div class="d-flex align-items-center justify-content-between mb-3">
                 <div class="mr-2">
                <a id="urlCycle" href="`+ value.urlCycle +`">
                 <span class="label label-light-primary font-weight-bolder label-inline ml-2">` + value.cycle + `</span>    
                <a>
                 <span class="text-muted ml-2"> `
                    + value.createdAt +
                    `</span>                                                
                 </div>                                            
                 </div>                                        
                 </div>
                 </div>`
                    , {class: 'result', text: value});

            //  document.getElementById('urlCycle').href = json.urlCycle;

            $('#timeline-items').append(newdiv);
        });

    }

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









