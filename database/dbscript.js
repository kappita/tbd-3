db.createCollection("voluntario")

db.voluntario.createIndex({ email: 1 }, { unique: true })
db.voluntario.createIndex({ rut: 1 }, { unique: true })

db.voluntario.insertMany([
    {
        nombre: "Andrea Juárez",
        email: "andrea.juarez@example.com",
        password: "pass123",
        rut: "12345678-9",
        habilidades: [],
        latitud: -33.475460477185464,
        longitud: -70.72326024012591,

    },
    {
        nombre: "Luis Navarro",
        email: "luis.navarro@example.com",
        password: "pass456",
        rut: "23456789-0",
        habilidades: [],
        latitud: -33.47538868364822,
        longitud: -70.72413394422644,
    },
    {
        nombre: "Carla Espinoza",
        email: "carla.espinoza@example.com",
        password: "pass789",
        rut: "14567890-1",
        habilidades: [],
        latitud: -39.295751618022386,
        longitud: -72.23595293617713,
    },
    {
        nombre: "Marco Antonio",
        email: "marco.antonio@example.com",
        password: "pass012",
        rut: "15678901-2",
        habilidades: [],
        latitud: -39.295938693967116,
        longitud: -72.23591193023263,
    },
    {
        nombre: "Ximena Soto",
        email: "ximena.soto@example.com",
        password: "pass345",
        rut: "16789012-3",
        habilidades: [],
        latitud: -39.295938693967116,
        longitud: -72.23591193023263,
    },
    {
        nombre: "Diego Morales",
        email: "diego.morales@example.com",
        password: "pass678",
        rut: "17890123-4",
        habilidades: [],
        latitud: -39.29429961138347,
        longitud: -72.23642324842609,
    },
    {
        nombre: "Rosa Campos",
        email: "rosa.campos@example.com",
        password: "pass901",
        rut: "18901234-5",
        habilidades: [],
        latitud: -39.294483889806955,
        longitud: -72.23594449904962,
    },
    {
        nombre: "Javier López",
        email: "javier.lopez@example.com",
        password: "pass234",
        rut: "19012345-6",
        habilidades: [],
        latitud: -39.29408053252056,
        longitud: -72.23546478607034,
    },
    {
        nombre: "Mónica Gutiérrez",
        email: "monica.gutierrez@example.com",
        password: "pass567",
        rut: "20123456-7",
        habilidades: [],
        latitud: -39.29572248782302,
        longitud: -72.23887361702606,
    },
    {
        nombre: "Esteban Rojas",
        email: "esteban.rojas@example.com",
        password: "pass890",
        rut: "21234567-8",
        habilidades: [],
        latitud: -39.29436198328951,
        longitud: -72.23953432795741,
    },
    {
        nombre: "Carmen Herrera",
        email: "carmen.herrera@example.com",
        password: "pass1234",
        rut: "20345678-0",
        habilidades: [],
        latitud: -39.29418905819766,
        longitud: -72.23939122721433,
    },
    {
        nombre: "Fernando Mora",
        email: "fernando.mora@example.com",
        password: "pass5678",
        rut: "23456789-1",
        habilidades: [],
        latitud: -53.161673785843504,
        longitud: -70.94343055289791,
    },
    {
        nombre: "Gabriela Castillo",
        email: "gabriela.castillo@example.com",
        password: "pass91011",
        rut: "21567890-2",
        habilidades: [],
        latitud: -53.160851706087755,
        longitud: -70.94572199434975,
    },
    {
        nombre: "Mauricio Pinto",
        email: "mauricio.pinto@example.com",
        password: "pass1213",
        rut: "22678901-3",
        habilidades: [],
        latitud: -27.3590183560186,
        longitud: -70.31368820371438,
    },
    {
        nombre: "Lucia Méndez",
        email: "lucia.mendez@example.com",
        password: "pass1415",
        rut: "22789012-4",
        habilidades: [],
        latitud: -27.35836069846974,
        longitud: -70.31283756029991,
    },
    {
        nombre: "Carmen Rosario",
        email: "carmen.reosario@example.com",
        password: "pass1234",
        rut: "21445678-0",
        habilidades: [],
        latitud: -20.235032129183317,
        longitud: -70.13005699582126,
    },
    {
        nombre: "Fernando Martinez",
        email: "fernando.martinez@example.com",
        password: "pass5678",
        rut: "22456789-2",
        habilidades: [],
        latitud: -20.237267679052415,
        longitud: -70.13047671112301,
    },
    {
        nombre: "Gabriela Gaete",
        email: "gabriela.gaete@example.com",
        password: "pass91011",
        rut: "20567890-2",
        habilidades: [],
        latitud: -20.236845974454152,
        longitud: -70.1310180399508,
    },
    {
        nombre: "Mauricio Martinez",
        email: "mauricio.martinez@example.com",
        password: "pass1213",
        rut: "20678901-2",
        habilidades: [],
        latitud: -20.236312329044015,
        longitud: -70.13053487778923,
    },
    {
        nombre: "Lucia Petinelli",
        email: "lucia.petinelli@example.com",
        password: "pass1415",
        rut: "21789012-2",
        habilidades: [],
        latitud: -33.23262573587894,
        longitud: -70.80860877689753,
    }
]);

db.createCollection("habilidad")

db.habilidad.insertMany([
    {
        _id: 1,
        nombre: "Primeros Auxilios",
        descripcion: "Capacidad para realizar atención inicial en emergencias médicas."
    },
    {
        _id: 2,
        nombre: "Incendios Forestales",
        descripcion: "Experiencia en combate de incendios en áreas naturales."
    },
    {
        _id: 3,
        nombre: "Remoción de escombros",
        descripcion: "Capacidad para realizar labores de remoción de escombros."
    },
    {
        _id: 4,
        nombre: "Asistencia Psicológica",
        descripcion: "Experiencia en el rubro de la psicología y trata de personas."
    },
    {
        _id: 5,
        nombre: "Búsqueda y Rescate",
        descripcion: "Habilidades especializadas en la localización y recuperación de personas atrapadas o perdidas."
    },
    {
        _id: 6,
        nombre: "Cocinero",
        descripcion: "Experiencia en Cocina para ollas comunes."
    }
]);

db.createCollection("admin")

db.admin.createIndex({ "email": 1 }, { unique: true });

db.admin.insertMany([
    { _id: 1, email: "admin1@example.com", password: "password" },
    { _id: 2, email: "admin2@example.com", password: "otrapassword" }
]);

