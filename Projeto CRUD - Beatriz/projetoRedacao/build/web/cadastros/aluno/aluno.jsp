<%@taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix= "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<h2>Alunos</h2>
<div class="panel-body">
    <table id="datatable" class="table table-striped table-bordered w-100">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>                
                <th>Escola</th>
                <th>Série</th>
                <th>E-mail</th>
                <th class="text-center">Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="aluno" items="${alunos}">
                <tr>
                    <td>${aluno.idaluno}</td>
                    <td>${aluno.nomealuno}</td>
                    <td>${aluno.escola.nomeescola}</td>
                    <td>${aluno.serie.descricao}</td>
                    <td>${aluno.email}</td>
                    <td class="text-center">
                        <a href="${pageContext.request.contextPath}/AlunoExcluir?idaluno=${aluno.idaluno}" class="btn btn-danger btn-sm">Excluir</a>
                        <a href="${pageContext.request.contextPath}/AlunoCarregar?idaluno=${aluno.idaluno}" class="btn btn-success btn-sm">Alterar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<div class="text-center mt-4">
    <a href="${pageContext.request.contextPath}/AlunoNovo" class="btn btn-primary">Novo</a>
    <a href="index.jsp" class="btn btn-secondary">Voltar à Página Inicial</a>
</div>

<script>
    $(document).ready(function() {
        console.log('entrei ready');
        //Carregamos a datatable
        //$("#datatable").DataTable(());
        $('#datatable').DataTable({
            "oLanguage": {
                "sProcessing": "Processando...",
                "sLengthMenu": "Mostrar _MENU_ registros",
                "sZeroRecords": "Nenhum registro encontrado.",
                "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                "sInfoEmpty": "Mostrando de 0 até 0 de 0 registros",
                "sInfoFiltered": "",
                "sInfoPostFix": "",
                "sSearch": "Buscar:",
                "sUrl": "",
                "oPaginate": {
                    "sFirst": "Primeiro",
                    "sPrevious": "Anterior",
                    "sNext": "Seguinte",
                    "sLast": "Último"
                }
                
            }
        });
    });
</script>

<%@include file="/footer.jsp"%>
