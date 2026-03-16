CREATE TABLE if NOT EXISTS Asignacion_Aplicacion_Perfil(
    AplCódigo int,
    PerCódigo int,
    PRIMARY KEY (AplCódigo, PerCódigo),
    FOREIGN KEY (AplCódigo) REFERENCES aplicaciones(AplCódigo),
    FOREIGN KEY (PerCódigo) REFERENCES perfiles(PerCódigo)

)ENGINE=InnoDB CHARACTER SET=LATIN1;
