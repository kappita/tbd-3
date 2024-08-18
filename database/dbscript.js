db.createCollection("voluntario")

db.voluntario.createIndex({ email: 1 }, { unique: true });
db.voluntario.createIndex({ rut: 1 }, { unique: true });


db.voluntario.insertMany([
    {
        
        nombre: "Andrea Juárez",
        rut: "12345678-9",
        habilidades:[],
        email: "andrea.juarez@example.com",
        password: ")64<JA5c3@-?3In6J4AEB",
    },
    {
        nombre: "Luis Navarro",
        rut: "23456789-0",
        habilidades:[],
        email: "luis.navarro@example.com",
        password: ")A;AKhB8?,>?=m5I3@DA;",
    },
    {
        nombre: "Carla Espinoza",
        rut: "14567890-1",
        habilidades:[],
        email: "carla.espinoza@example.com",
        password: ")8'JD=`<<;5;=I1o7K5BF",
    },
    {
        nombre: "Marco Antonio",
        rut: "15678901-2",
        habilidades:[],
        email: "marco.antonio@example.com",
        password: ")B'J;K`87?;;7>n6J4AEB",
    },
    {
        nombre: "Ximena Soto",
        rut: "16789012-3",
        habilidades:[],
        email: "ximena.soto@example.com",
        password: ")M/E=J5c<:@<l4H2?C@:b",
    },
    {
        nombre: "Diego Morales",
        rut: "17890123-4",
        habilidades:[],
        email: "diego.morales@example.com",
        password: ")9/=?K`D8=-93Bn6J4AEB",
    },
    {
        nombre: "Rosa Campos",
        rut: "18901234-5",
        habilidades:[],
        email: "rosa.campos@example.com",
        password: ")G5K9h786;;@l4H2?C@:b",
    },
    {
        nombre: "Javier López",
        rut: "19012345-6",
        habilidades:[],
        email: "javier.lopez@example.com",
        password: ")?'NAAFc5:<2Hm5I3@DA;",
    },
    {
        nombre: "Mónica Gutiérrez",
        rut: "20123456-7",
        habilidades:[],
        email: "monica.gutierrez@example.com",
        password: ")B5FA?5c0@@63AB6Lq9M7",
    },
    {
        nombre: "Esteban Rojas",
        rut: "21234567-8",
        habilidades:[],
        email: "esteban.rojas@example.com",
        password: "):9L=>5EU=;7/Bn6J4AEB",
    },
    {
        nombre: "Carmen Herrera",
        rut: "20345678-0",
        habilidades:[],
        email: "carmen.herrera@example.com",
        password: ")8'JEABc10>?3A1o7K5BF",
    },
    {
        nombre: "Fernando Mora",
        rut: "23456789-1",
        habilidades:[],
        email: "fernando.mora@example.com",
        password: ");+JF=B;8W9<@0n6J4AEB",
    },
    {
        nombre: "Gabriela Castillo",
        rut: "21567890-2",
        habilidades:[],
        email: "gabriela.castillo@example.com",
        password: ")<':JE9C*W/.AC9=>Br:N",
    },
    {
        nombre: "Mauricio Pinto",
        rut: "22678901-3",
        habilidades:[],
        email: "mauricio.pinto@example.com",
        password: ")B'MJE7@8W<6<C?o7K5BF",
    },
    {
        nombre: "Lucia Méndez",
        rut: "22789012-4",
        habilidades:[],
        email: "lucia.mendez@example.com",
        password: ")A;;A=`D.902Hm5I3@DA;",
    },
    {
        nombre: "Carmen Rosario",
        rut: "21445678-0",
        habilidades:[],
        email: "carmen.reosario@example.com",
        password: ")8'JEABc;0;@/A9@p8L6C",
    },
    {
        nombre: "Fernando Martinez",
        rut: "22456789-2",
        habilidades:[],
        email: "fernando.martinez@example.com",
        password: ");+JF=B;8W9.@C9?7Mr:N",
    },
    {
        nombre: "Gabriela Gaete",
        rut: "20567890-2",
        habilidades:[],
        email: "gabriela.gaete@example.com",
        password: ")<':JE9C*W3.3C5o7K5BF",
    },
    {
        nombre: "Mauricio Martinez",
        rut: "20678901-2",
        habilidades:[],
        email: "mauricio.martinez@example.com",
        password: ")B'MJE7@8W9.@C9?7Mr:N",
    },
    {
        nombre: "Lucia Petinelli",
        rut: "21789012-2",
        habilidades:[],
        email: "lucia.petinelli@example.com",
        password: ")A;;A=`G.?5;3;<:p8L6C",
    }
]);

db.createCollection("habilidad")

db.habilidad.insertMany([
    {
        nombre: "Primeros Auxilios",
        descripcion: "Capacidad para realizar atención inicial en emergencias médicas."
    },
    {
        nombre: "Incendios Forestales",
        descripcion: "Experiencia en combate de incendios en áreas naturales."
    },
    {
        nombre: "Remoción de escombros",
        descripcion: "Capacidad para realizar labores de remoción de escombros."
    },
    {
        nombre: "Asistencia Psicológica",
        descripcion: "Experiencia en el rubro de la psicología y trata de personas."
    },
    {
        nombre: "Búsqueda y Rescate",
        descripcion: "Habilidades especializadas en la localización y recuperación de personas atrapadas o perdidas."
    },
    {
        nombre: "Cocinero",
        descripcion: "Experiencia en Cocina para ollas comunes."
    }
]);

db.createCollection("admin")

db.admin.createIndex({ "email": 1 }, { unique: true });

db.admin.insertMany([
    { email: "admin1@example.com", password: ")6*EAJcu.C-:>;5]5BA6:" },
    { email: "david.admin@example.com", password: ")9'NA@`8-85;l4H2?C@:b" }
]);

