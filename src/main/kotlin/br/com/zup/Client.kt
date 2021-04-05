package br.com.zup

import io.grpc.ManagedChannelBuilder

fun main() {

    val channel = ManagedChannelBuilder
        .forAddress("localhost", 50051)
        .usePlaintext()
        .build()


    val request = FuncionarioRequest
        .newBuilder()
        .setNome("Eduardo Diniz")
        .setCpf("123.123.123-12")
        .setSalario(2000.20)
        .setAtivo(true)
        .setCargo(Cargo.DEV)
        .addEnderecos(
            FuncionarioRequest.Endereco.newBuilder()
                .setLogradouro("Rua Costa Barros")
                .setCep("03210-001")
                .setComplemento("123")
                .build()
        )
        .build()

    val client = FuncionarioServiceGrpc.newBlockingStub(channel)

    val response = client.cadastrar(request)
    println(response)
}