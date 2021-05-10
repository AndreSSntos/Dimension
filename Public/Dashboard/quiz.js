var vezes = 0;
var vezes2 = 0;
var vezes3 = 0;

function escolhaNoite() {
    document.getElementById('pergunta1').style.display = "none";
    document.getElementById('pergunta2').style.display = "block";
    document.getElementById('loader').style.display = "none";
    document.getElementById('loader2').style.display = "block";
    vezes++;
}

function escolhaTarde() {
    document.getElementById('pergunta1').style.display = "none";
    document.getElementById('pergunta2').style.display = "block";
    document.getElementById('loader').style.display = "none";
    document.getElementById('loader2').style.display = "block";
    vezes2++;
}

function escolhaManha() {
    document.getElementById('pergunta1').style.display = "none";
    document.getElementById('pergunta2').style.display = "block";
    document.getElementById('loader').style.display = "none";
    document.getElementById('loader2').style.display = "block";
    vezes3++;
}

function escolha2() {
    document.getElementById('pergunta2').style.display = "none";
    document.getElementById('pergunta3').style.display = "block";
    document.getElementById('loader2').style.display = "none";
    document.getElementById('loader3').style.display = "block";
    vezes2++;
 }

function escolha4() {
    document.getElementById('pergunta2').style.display = "none";
    document.getElementById('pergunta3').style.display = "block";
    document.getElementById('loader2').style.display = "none";
    document.getElementById('loader3').style.display = "block";
    vezes3++;
}
function escolha6() {
    document.getElementById('pergunta2').style.display = "none";
    document.getElementById('pergunta3').style.display = "block";
    document.getElementById('loader2').style.display = "none";
    document.getElementById('loader3').style.display = "block";
    vezes++;
}
function escolhaUm() {
    document.getElementById('pergunta3').style.display = "none";
    document.getElementById('titulo').style.display = "none";
    document.getElementById('mascote').style.display = "block";
    document.getElementById('loader').style.display = "none";
    document.getElementById('loader4').style.display = "block";
    vezes++;
    var nome = nome.innerHTML;
    if(vezes > vezes2 && vezes > vezes3){
        nome = `Noa`;
    }
    else if(vezes2 > vezes && vezes2 > vezes3){
        nome = `Douglinha`;
    }
    else{
        nome = `Marquin`;
    }
    
}
function escolhaDois() {
    document.getElementById('pergunta3').style.display = "none";
    document.getElementById('titulo').style.display = "none";
    document.getElementById('mascote').style.display = "block";
    document.getElementById('loader').style.display = "none";
    document.getElementById('loader4').style.display = "block";
    vezes2++;
       var nome = nome.innerHTML;
    if(vezes > vezes2 && vezes > vezes3){
        nome = `Noa`;
    }
    else if(vezes2 > vezes && vezes2 > vezes3){
        nome = `Douglinha`;
    }
    else{
        nome = `Marquin`;
    }
}
function escolhaTres() {
    document.getElementById('pergunta3').style.display = "none";
    document.getElementById('titulo').style.display = "none";
    document.getElementById('mascote').style.display = "block";
    document.getElementById('loader').style.display = "none";
    document.getElementById('loader4').style.display = "none";
    vezes3++;
    var nome = nome.innerHTML;
    if(vezes > vezes2 && vezes > vezes3){
        nome = `Noa`;
    }
    else if(vezes2 > vezes && vezes2 > vezes3){
        nome = `Douglinha`;
    }
    else{
        nome = `Marquin`;
    }
}









