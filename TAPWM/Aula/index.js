var http = require('http')

http.createServer(function(req, res){
    res.send("Mensagem direcionada")
}).listen(8081)

console.log("Servidor está ativo")