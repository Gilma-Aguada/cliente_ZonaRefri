import { useState } from 'react';

const Registro = () => {
    const [nombre, setNombre] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        
        // Datos que espera tu Backend (UsuarioController)
        const nuevoUsuario = { nombre, email, password };

        try {
            const respuesta = await fetch("http://localhost:8080/api/usuarios/registro", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(nuevoUsuario)
            });

            if (respuesta.ok) {
                alert("¡Usuario registrado con éxito!");
            } else {
                alert("Error en el registro. Revisa el Backend.");
            }
        } catch (error) {
            console.error("Error de conexión:", error);
        }
    };

    return (
        <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', gap: '10px', maxWidth: '300px' }}>
            <h2>Registro de Cliente</h2>
            <input type="text" placeholder="Nombre" onChange={(e) => setNombre(e.target.value)} required />
            <input type="email" placeholder="Email" onChange={(e) => setEmail(e.target.value)} required />
            <input type="password" placeholder="Contraseña" onChange={(e) => setPassword(e.target.value)} required />
            <button type="submit">Crear Cuenta</button>
        </form>
    );
};

export default Registro;