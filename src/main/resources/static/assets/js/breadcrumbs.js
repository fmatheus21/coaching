var icon = ' <i class="fas fa-angle-double-right"></i>';


function dashboard() {
    var breadcrumbs = `<li class="breadcrumb-item"><a href="/dashboard" class="text-muted">Dashboard</a></li>`;
    document.getElementById("breadcrumb").innerHTML = breadcrumbs;
    $('#dashboard').addClass("menu-item-active");
}

function coaches() {
    var breadcrumbs = `
<li class="breadcrumb-item"><a href="/dashboard" class="text-muted">Dashboard</a></li> 
<li class="breadcrumb-item"><a href="/coaches" class="text-muted">Coaches</a></li>`;
    document.getElementById("breadcrumb").innerHTML = breadcrumbs;
    $('#coaches').addClass("menu-item-active");
}

function coaches_assessments() {
    var breadcrumbs = `
<li class="breadcrumb-item"><a href="/dashboard" class="text-muted">Dashboard</a></li> 
    <li class="breadcrumb-item"><span class="text-muted">Coache</span></li> 
<li class="breadcrumb-item"><a href="" class="text-muted">Avaliações</a></li>`;
    document.getElementById("breadcrumb").innerHTML = breadcrumbs;
    $('#assessments').addClass("menu-item-active");
}

function assessments() {
    var breadcrumbs = `
<li class="breadcrumb-item"><a href="/dashboard" class="text-muted">Dashboard</a></li> 
<li class="breadcrumb-item"><a href="/assessments" class="text-muted">Avaliações</a></li>`;
    document.getElementById("breadcrumb").innerHTML = breadcrumbs;
    $('#assessments').addClass("menu-item-active");
}











