/**
 * Lógica de interacción para Zona Refri
 */

// Función para el formulario de contacto general
function enviarAWhatsApp() {
    const nombre = document.getElementById('cliente-nombre').value;
    const aparato = document.getElementById('cliente-aparato').value;
    const mensaje = document.getElementById('cliente-mensaje').value;
    const numero = "5491123028129"; 

    if (nombre.trim() === "" || aparato.trim() === "") {
        alert("Por favor, completá al menos tu nombre y el aparato para que podamos asesorarte. ❄️");
        return;
    }

    // Construimos el mensaje para WhatsApp
    const textoMensaje = `Hola Zona Refri! ❄️\n\nMi nombre es: ${nombre}\nConsulta por: ${aparato}\nDetalle: ${mensaje}`;
    
    // Codificamos el texto para que sea válido en una URL
    const urlWhatsApp = `https://wa.me/${numero}?text=${encodeURIComponent(textoMensaje)}`;
    
    // Abrimos WhatsApp en una nueva pestaña
    window.open(urlWhatsApp, '_blank');
}

// Mensaje de confirmación opcional al hacer click en botones de compra directos
document.querySelectorAll('.cta-btn').forEach(button => {
    button.addEventListener('click', () => {
        console.log('Redirigiendo a WhatsApp para concretar compra...');
    });
});