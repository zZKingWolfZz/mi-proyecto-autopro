document.addEventListener("DOMContentLoaded", () => {
    const loginForm = document.getElementById("loginForm");

    const usuariosPermitidos = [
        { user: "admin", pass: "12345" },
        { user: "arniel", pass: "wolf2026" },
        { user: "invitado", pass: "clave123" }
    ];

    loginForm.addEventListener("submit", (event) => {
        event.preventDefault();

        const userInput = document.getElementById("usuario").value;
        const passInput = document.getElementById("password").value;
        const coincide = usuariosPermitidos.find(u => u.user === userInput && u.pass === passInput);

        if (coincide) {
            alert("¡Acceso correcto!");

            window.location.href = "/dashboard";
        } else {
            alert("Usuario o contraseña no encontrados.");
        }
    });
});