<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<form name="cadastraraluno" action="AlunoCadastrar" method="POST">
    <table align="center" border="0">
        <thead>
            <tr>
                <th colspan="2" align="center">Cadastro De Alunos</th>
            </tr>
            <tr>
                <th colspan="2" align="center">${mensagem}</th>
            </tr>
        </thead>
        <tbody>
            <tr><td>ID: </td>
            <td><input type="text" name="idaluno" id="idaluno" value="${aluno.idaluno}" readonly="readonly" /></td></tr>
            <tr><td>Nome: </td>
            <td><input type="text" name="nomealuno" id="nomealuno" value="${aluno.nomealuno}"
                       size="50" maxlength="50"/></td></tr>
            <tr><td>Série: </td>
                <td>
                    <select name="serie" id="serie">
                        <option value="1">Primeira Série</option>
                        <option value="2">Segunda Série</option>
                        <option value="3">Terceira Série</option>
                    </select>
                </td>
            <tr><td>Escola: </td>
                <td>
                    <select name="idescola" id="idescola">
                        <option value="">Selecione: </option>
                            <c:forEach var="escola" items="${escolas}">
                            <option value="${escola.idescola}"
                                ${aluno.escola.nomeescola == escola.nomeescola ? "selected": ""}>
                                ${escola.nomeescola}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            <tr><td>E-mail: </td>
            <td><input type="text" name="emailaluno" id="emailaluno" value="${aluno.email}"
                       size="50" maxlength="50"/></td></tr>    
            <tr><td colspan="2" align="center">
                <input type="submit" name="cadastrar" id="cadastrar" value="cadastrar" />
                <input type="reset" name="limpar" id="limpar" value="Limpar">
            </td></tr>
            <tr>
                <td align="center" colspan="2"><h5><a href="index.jsp" class="btn btn-secondary">Voltar à página Inicial</a></h5></td>
            </tr>
        </tbody>   
    </table>
</form>
<%@include file="/footer.jsp" %>
 