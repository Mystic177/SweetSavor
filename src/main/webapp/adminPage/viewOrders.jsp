<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Prodotto" %>
<%@ page import="model.ProdottoDao" %>
<%@ page import="model.ProdottoDaoInterface" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="model.Ordine" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Lista ordini</title>
    <link rel="stylesheet" href="../CSS/admin.css">
</head>
<body>
<div class="card section">
    <h1>Lista degli ordini effettuati.</h1>
    <%
        ArrayList<Ordine> listaOrdini = (ArrayList<Ordine>) request.getAttribute("listaOrdini");
        if (listaOrdini != null && !listaOrdini.isEmpty()) {
    %>
    <table>
        <thead>
        <tr>
            <th>ID Ordine</th>
            <th>Data Ordine</th>
            <th>Nome Cliente</th>
            <th>Cognome Cliente</th>
            <th>CAP</th>
            <th>Indirizzo di Consegna</th>
            <th>Totale</th>
            <th>Stato</th>
        </tr>
        </thead>
        <tbody>
        <% for (Ordine ordine : listaOrdini) { %>
        <tr>
            <td><%= ordine.getOrderID() %></td>
            <td><%= ordine.getDataOrdine() %></td>
            <td><%= ordine.getNomeCliente() %></td>
            <td><%= ordine.getCognomeCliente() %></td>
            <td><%= ordine.getCap() %></td>
            <td><%= ordine.getIndirizzoDiConsegna() %></td>
            <td>€<%= ordine.getTotale() %></td>
            <td><%= ordine.isStato() ? "Completato" : "In corso" %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <% } else { %>
    <p>Al momento non ci sono ordini effettuati.</p>
    <% } %>
</div>
