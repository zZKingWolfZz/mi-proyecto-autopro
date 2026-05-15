
const userMenu = document.querySelector('.user-menu');

userMenu.addEventListener('click', () => {
    userMenu.classList.toggle('active');
});

// Cerrar al hacer click fuera
document.addEventListener('click', (e) => {
    if (!userMenu.contains(e.target)) {
        userMenu.classList.remove('active');
    }
});


