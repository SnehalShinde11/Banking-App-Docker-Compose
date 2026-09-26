const express = require("express");

const app = express();
const PORT = 3000;

app.use(express.json());

const accounts = [
    {
        id: 101,
        name: "Snehal",
        balance: 50000
    },
    {
        id: 102,
        name: "Rahul",
        balance: 75000
    }
];

app.get("/", (req, res) => {
    res.json({
        service: "Account Service",
        status: "UP"
    });
});

app.get("/health", (req, res) => {
    res.json({
        service: "Account Service",
        status: "healthy"
    });
});

app.get("/accounts", (req, res) => {
    res.json(accounts);
});

app.get("/accounts/:id", (req, res) => {

    const account = accounts.find(
        a => a.id === parseInt(req.params.id)
    );

    if (!account) {
        return res.status(404).json({
            message: "Account not found"
        });
    }

    res.json(account);
});

app.listen(PORT, "0.0.0.0", () => {
    console.log(`Account Service running on port ${PORT}`);
});