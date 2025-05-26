const express = require("express")
const app = express()
const bodyParser = require("body-parser")

const { initializeApp, cert } = require('firebase-admin/app')
const { getFirestore } = require('firebase-admin/firestore')
const serviceAccount = require('./firebase-key.json')

initializeApp({ credential: cert(serviceAccount) })
const db = getFirestore()

const exphbs = require("express-handlebars")

const hbs = exphbs.create({
  defaultLayout: "main",
  helpers: {
    eq: (a, b) => a === b
  }
})

app.engine("handlebars", hbs.engine)
app.set("view engine", "handlebars")


app.use(bodyParser.urlencoded({ extended: false }))
app.use(bodyParser.json())

app.get("/", function(req, res) {
  const success = req.query.success === "true"
  res.render("primeira_pagina", { success })
})

app.get("/consulta", async function(req, res) {
  try {
    const snapshot = await db.collection("agendamentos").get()
    const dados = []

    snapshot.forEach(doc => {
      dados.push({ id: doc.id, ...doc.data() })
    })

    res.render("consulta", { post: dados })
  } catch (err) {
    console.error("Erro ao consultar:", err)
    res.status(500).send("Erro ao carregar os dados")
  }
})

app.post("/cadastrar", function(req, res) {
  db.collection('agendamentos').add({
    nome: req.body.nome,
    telefone: req.body.telefone,
    origem: req.body.origem,
    data_contato: req.body.data_contato,
    observacao: req.body.observacao
  }).then(() => {
    // Redireciona para a página principal com query ?success=true para mostrar o modal
    res.redirect("/?success=true")
  }).catch((error) => {
    console.error("Erro ao cadastrar:", error)
    res.send("Erro ao cadastrar.")
  })
})

app.get("/excluir/:id", async function(req, res) {
  try {
    await db.collection("agendamentos").doc(req.params.id).delete()
    res.redirect("/consulta")
  } catch (err) {
    console.error("Erro ao excluir:", err)
    res.send("Erro ao excluir.")
  }
})

app.get("/editar/:id", async function(req, res) {
  try {
    const doc = await db.collection("agendamentos").doc(req.params.id).get()
    if (!doc.exists) return res.send("Registro não encontrado.")

    const dados = { id: doc.id, ...doc.data() }
    res.render("editar", { dados })
  } catch (err) {
    console.error("Erro ao buscar dados:", err)
    res.send("Erro ao carregar dados para edição.")
  }
})

app.post("/atualizar", async function(req, res) {
  try {
    await db.collection("agendamentos").doc(req.body.id).update({
      nome: req.body.nome,
      telefone: req.body.telefone,
      origem: req.body.origem,
      data_contato: req.body.data_contato,
      observacao: req.body.observacao
    })
    res.redirect("/consulta")
  } catch (err) {
    console.error("Erro ao atualizar:", err)
    res.send("Erro ao atualizar os dados.")
  }
})

app.listen(8081, function() {
  console.log("Servidor ativo em http://localhost:8081")
})
