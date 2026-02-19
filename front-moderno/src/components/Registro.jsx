import { useState } from 'react';

const Registro = () => {
    const [nombre, setNombre] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
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
            alert("No se pudo conectar con el servidor. ¿Está el Backend prendido?");
        }
    };

    return (
        <div className="p-3">
            <h3 className="mb-4" style={{ fontWeight: '700', color: '#00509d' }}>Crear Cuenta</h3>
            <form onSubmit={handleSubmit} className="d-flex flex-column gap-3">
                <input 
                    type="text" 
                    className="form-control py-2" 
                    placeholder="Tu nombre completo" 
                    onChange={(e) => setNombre(e.target.value)} 
                    required 
                />
                <input 
                    type="email" 
                    className="form-control py-2" 
                    placeholder="Correo electrónico" 
                    onChange={(e) => setEmail(e.target.value)} 
                    required 
                />
                <input 
                    type="password" 
                    className="form-control py-2" 
                    placeholder="Contraseña segura" 
                    onChange={(e) => setPassword(e.target.value)} 
                    required 
                />
                <button 
                    type="submit" 
                    className="btn btn-primary py-2 fw-bold" 
                    style={{ backgroundColor: '#007bff', borderRadius: '10px' }}
                >
                    Registrarme
                </button>
            </form>
        </div>
    );
};

export default Registro;