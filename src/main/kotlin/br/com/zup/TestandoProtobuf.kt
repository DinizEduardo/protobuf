package br.com.zup

import jdk.swing.interop.SwingInterOpUtils
import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {

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

    println(request)

    request.writeTo(FileOutputStream("funcionario-request.bin"))

    val request2 = FuncionarioRequest
        .newBuilder()
        .mergeFrom(FileInputStream("funcionario-request.bin"))

    request2.setCargo(Cargo.GERENTE)
        .build()

    println(request2)



}