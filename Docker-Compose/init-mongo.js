db.createUser(
    {
        user: "admin",
        pwd: "Hola1234",
        roles: [
            {
                role: "readWrite",
                db: "ArepWebApp"
            }
        ]
    }
)