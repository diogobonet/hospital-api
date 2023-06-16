const formulario = document.querySelector('form')
const botao = document.querySelector('button')
const inome = document.querySelector('.nome')
const iendereço = document.querySelector('.endereço')

function cadastrar() {
    fetch("http://localhost:8080/pacientes"),
    {
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        method: "POST",
        body: JSON.stringify(
            {
                nome: inome.value,
                endereco: iendereço.value
            }
        )
        .then(function(res) {console.log(res)})
        .catch(function(res) {console.log(res)})
    }
}

formulario.addEventListener("submit"), function (event) {
    event.preventDefault();
    cadastrar();
}