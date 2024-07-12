<%@taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<form name="cadastrarescola" action="EscolaCadastrar" method="POST">
    <table align="center" border="0"> 
        <thead>
            <tr>
                <th colspan="2" align="center">
                    Cadastro De Escola
                </th>
            </tr>
            <tr>
                <th colspan="2" align="center"> 
                    ${mensagem}
                </th>
            </tr>
        </thead>
        <tbody>
            <tr><td>ID: </td>
            <td><input type="text" name="idescola" id="idescola" value="${escola.idescola}" readonly="readonly"></td></tr>
            <tr><td>Nome: </td>
            <td><input type="text" name="nomeescola" id="nomeescola" value="${escola.nomeescola}" size="50" maxlength="50"></td></tr>
            <tr><td>Endereço: </td>
            <td><input type="text" name="endereco" id="endereco" value="${escola.endereco}" size="50" maxlength="50"></td></tr>
            <tr><td>Telefone: </td>
            <td><input type="text" name="telefone" id="telefone" value="${escola.telefone}"></td></tr>
            <tr><td colspan="2" align="center">
                <input type="submit" name="cadastrar" id="cadastrar" value="cadastrar" />
                <input type="reset" name="limpar" id="limpar" value="Limpar"></td>
            </tr>
            <tr>
                <td align="center" colspan="2"><h5><a href="index.jsp" class="btn btn-secondary">Voltar á Página Inicial</a></h5></td>
            </tr>
        </tbody>
    </table>
</form>
<%@include file="/footer.jsp" %>
