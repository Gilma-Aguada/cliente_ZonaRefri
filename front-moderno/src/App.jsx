import React from 'react'
import logoRobot from './assets/logo-refri.jpeg'

function App() {
  return (
    <div style={{ backgroundColor: '#ffffff', minHeight: '100vh', fontFamily: "'Sora', sans-serif", overflowX: 'hidden' }}>
      
      {/* 1. HEADER NARANJA */}
      <header style={{ backgroundColor: '#ff9f43', padding: '20px 0' }}>
        <div className="container-fluid px-md-5">
          <div className="row align-items-center">
            
            {/* LADO IZQUIERDO: (VACÍO para limpieza visual) */}
            <div className="col-auto">
              <div style={{ width: '40px' }}></div> 
            </div>

            {/* BUSCADOR CENTRAL */}
            <div className="col">
              <div className="input-group shadow-sm" style={{ borderRadius: '15px', overflow: 'hidden', maxWidth: '750px', margin: '0 auto' }}>
                <input type="text" className="form-control border-0 py-3 px-4" placeholder="¿Qué repuesto estás buscando hoy?" style={{ fontSize: '1.1rem' }} />
                <button className="btn btn-primary px-4 border-0" style={{ backgroundColor: '#007bff' }}>
                    <span style={{ fontSize: '1.4rem' }}>🔍</span>
                </button>
              </div>
            </div>

            {/* NOMBRE Y WHATSAPP (DERECHA) */}
            <div className="col-auto text-white text-end">
              <h1 className="m-0" style={{ fontSize: '1.8rem', fontWeight: '800', letterSpacing: '-1px', lineHeight: '1' }}>Zona Refri</h1>
              <div style={{ fontSize: '1rem', fontWeight: 'bold', opacity: '0.9', marginTop: '5px' }}>
                📞 11-2302-8129
              </div>
            </div>
          </div>

          {/* NAVBAR DE CATEGORÍAS */}
          <nav className="d-flex gap-4 mt-4 text-white fw-bold px-md-5" style={{ fontSize: '1rem', opacity: '0.9' }}>
            <span style={{cursor:'pointer'}}>Heladeras</span>
            <span style={{cursor:'pointer'}}>Lavarropas</span>
            <span style={{cursor:'pointer'}}>Microondas</span>
            <span style={{cursor:'pointer'}}>Aires</span>
            <span style={{cursor:'pointer'}}>Repuestos</span>
            <span style={{cursor:'pointer'}}>Servicio Técnico</span>
          </nav>
        </div>
      </header>

      {/* 2. SECCIÓN PRINCIPAL */}
      <main className="container-fluid p-0">
        <div className="row g-0">
          
          {/* BLOQUE DE TEXTO */}
          <div className="col-lg-6 p-5 d-flex flex-column justify-content-center bg-white" style={{ minHeight: '80vh' }}>
            <div className="ps-md-5">
              <span className="badge rounded-pill px-4 py-2 mb-4" style={{ backgroundColor: '#e8f0fe', color: '#00509d', fontSize: '1rem', fontWeight: 'bold' }}>
                🔵 Servicio hoy disponible
              </span>
              
              {/* TÍTULO AJUSTADO A 4rem */}
              <h2 className="mb-4" style={{ color: '#1a1a1a', fontSize: '4rem', letterSpacing: '-3px', lineHeight: '1.1', fontWeight: '800' }}>
                Tu electrodoméstico <br />
                <span style={{ color: '#007bff' }}>merece lo mejor</span>
              </h2>
              
              <p className="text-secondary mb-5" style={{ fontSize: '1.5rem', maxWidth: '550px' }}>
                Repuestos originales y servicio técnico especializado. <br />
                <strong>Garantía escrita en Berazategui.</strong>
              </p>
              
              <div className="d-flex gap-4">
                <button className="btn btn-lg px-5 py-3 text-white shadow-lg border-0" style={{ backgroundColor: '#00509d', borderRadius: '15px', fontWeight: 'bold' }}>
                  Ver Catálogo →
                </button>
                <button className="btn btn-outline-dark btn-lg px-5 py-3 fw-bold" style={{ borderRadius: '15px', borderWidth: '2px' }}>
                  Pedir Técnico
                </button>
              </div>
            </div>
          </div>

          {/* BLOQUE DEL ROBOT */}
          <div className="col-lg-6 d-flex align-items-center justify-content-center" style={{ backgroundColor: '#00509d', minHeight: '80vh' }}>
            <div className="position-relative">
              {/* Círculo de fondo que resalta al robot */}
              <div className="position-absolute top-50 start-50 translate-middle" style={{ width: '580px', height: '580px', backgroundColor: '#ffd32a', borderRadius: '50%', opacity: '0.9' }}></div>
              
              <img 
                src={logoRobot} 
                alt="Robot Zona Refri" 
                className="position-relative shadow-lg"
                style={{ 
                  width: '520px', 
                  height: '520px', 
                  borderRadius: '50%', 
                  objectFit: 'cover',
                  border: '15px solid white'
                }} 
              />
            </div>
          </div>

        </div>
      </main>
    </div>
  )
}

export default App