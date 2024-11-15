CREATE TABLE franquicias (
    id_franquicia INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE sucursales (
    id_sucursal INT PRIMARY KEY AUTO_INCREMENT,
    id_franquicia INT,
    nombre VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (id_franquicia) REFERENCES franquicias(id_franquicia)
);

CREATE TABLE productos (
    id_producto INT PRIMARY KEY AUTO_INCREMENT,
    id_sucursal INT,
    nombre VARCHAR(100) NOT NULL,
    stock INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    FOREIGN KEY (id_sucursal) REFERENCES sucursales(id_sucursal)
);
