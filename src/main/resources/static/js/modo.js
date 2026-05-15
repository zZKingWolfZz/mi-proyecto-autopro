const sidebar = document.querySelector('.sidebar');
const menuBtn = document.querySelector('.menu-btn');

menuBtn.addEventListener('click', () => {
    if (window.innerWidth <= 768) {
        sidebar.classList.toggle('show');
    } else {
        sidebar.classList.toggle('collapsed');
    }
});
const btnAplicar = document.getElementById('aplicarTema');
const claro = document.getElementById('tema-claro');
const oscuro = document.getElementById('tema-oscuro');

// Cargar preferencia guardada
if (localStorage.getItem('theme') === 'dark') {
    document.body.classList.add('dark');
    oscuro.checked = true;
} else {
    claro.checked = true;
}

// Aplicar tema
btnAplicar.addEventListener('click', () => {
    if (oscuro.checked) {
        document.body.classList.add('dark');
        localStorage.setItem('theme', 'dark');
    } else {
        document.body.classList.remove('dark');
        localStorage.setItem('theme', 'light');
    }
});



const idiomaSelect = document.getElementById('idiomaSelect');

/* Diccionario de idiomas */
const idiomas = {
    es: {
        dashboard: "Dashboard",
        ventas: "Ventas",
        clientes: "Clientes",
        reportes: "Reportes",
        configuracion: "Configuración",
        idioma: "Idioma"
    },
    en: {
        dashboard: "Dashboard",
        ventas: "Sales",
        clientes: "Clients",
        reportes: "Reports",
        configuracion: "Settings",
        idioma: "Language"
    }
};

/* Cargar idioma guardado */
const idiomaGuardado = localStorage.getItem('idioma') || 'es';
idiomaSelect.value = idiomaGuardado;
aplicarIdioma(idiomaGuardado);

/* Cambiar idioma */
idiomaSelect.addEventListener('change', () => {
    const idioma = idiomaSelect.value;
    localStorage.setItem('idioma', idioma);
    aplicarIdioma(idioma);
});

/* Aplicar idioma */
function aplicarIdioma(idioma){
    document.querySelector('.titulo').textContent = idiomas[idioma].dashboard;

    document.querySelector('[data-menu="ventas"]').textContent = idiomas[idioma].ventas;
    document.querySelector('[data-menu="clientes"]').textContent = idiomas[idioma].clientes;
    document.querySelector('[data-menu="reportes"]').textContent = idiomas[idioma].reportes;
    document.querySelector('[data-menu="configuracion"]').textContent = idiomas[idioma].configuracion;
}

