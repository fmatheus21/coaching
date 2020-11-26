var icon = ' <i class="fas fa-angle-double-right"></i>';


function dashboard() {
    var breadcrumbs = `<li class="breadcrumb-item"><a href="/dashboard" class="text-muted">Dashboard</a></li>`;
    document.getElementById("breadcrumb").innerHTML = breadcrumbs;
    $('#dashboard').addClass("menu-item-active");
}

function coachees() {
    var breadcrumbs = `
<li class="breadcrumb-item"><a href="/dashboard" class="text-muted">Dashboard</a></li> 
<li class="breadcrumb-item"><a href="" class="text-muted">Coaches</a></li>`;
    document.getElementById("breadcrumb").innerHTML = breadcrumbs;
    $('#coaches').addClass("menu-item-active");
}

function coachees_assessments() {
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
<li class="breadcrumb-item"><a href="" class="text-muted">Avaliações</a></li>`;
    document.getElementById("breadcrumb").innerHTML = breadcrumbs;
    $('#assessments').addClass("menu-item-active");
}

function team_coaching() {
    var breadcrumbs = `
<li class="breadcrumb-item"><a href="/dashboard" class="text-muted">Dashboard</a></li> 
<li class="breadcrumb-item"><a href="" class="text-muted">Team Coaching</a></li>`;
    document.getElementById("breadcrumb").innerHTML = breadcrumbs;
    $('#team-coaching').addClass("menu-item-active");
}











