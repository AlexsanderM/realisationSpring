<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
<@l.logout />
    <span><a href="/user">List</a></span>
</div>
<div>
    <form method="post">
        <input type="text" name="service" placeholder="service:"/>
        <input type="number" name="kratnost" placeholder="kratnost:"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Add</button>
    </form>
</div>
<form method="get" action="/main">
    <input type="text" name="filter" value="${filter?ifExists}"/>
    <button type="submit">Search</button>
</form>
<div>Service</div>
<#list services as service>
<div>
    <b>${service.id}</b>
    <span>${service.service}</span>
    <i>${service.kratnost}</i>
    <strong>${service.authorName}</strong>
</div>
<#else>
Null
</#list>
</@c.page>