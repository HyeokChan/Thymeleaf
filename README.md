# Thymeleaf
***

## 메시지 처리
#### messages.properties 설정
```
home.welcome=Welcome to our website, <b>{0}</b>!
img.logo = logo
role.admin = ADMIN
role.manager = MANAGER
role.guest = GUEST
date.format=MMMM dd, yyyy
```
#### message 활용
```
<div class="row">
    <div class="col-md-12">
        <!--메시지표현식-->
        <h2 class="text-black" th:utext="#{home.welcome(${user.userName})}">welcome</h2>
    </div>
</div>
```
***
## 변수표현식
#### model 세팅
```
@GetMapping("/")
public String home(Model model) {
    /*현재날짜*/
    model.addAttribute("today", Calendar.getInstance());
    /*사용자*/
    User user = new User();
    user.setUserId(1L);
    user.setUserName("chan");
    user.setUserEml("chan@naver.com");
    model.addAttribute("user", user);
    return "home";
}
```
#### 변수표현식
```
<div class="row">
    <div class="col-md-12">
        <!--변수표현식, 리터럴대체, calendars유틸리티개체-->
        <p th:text="|Today is ${#calendars.format(today, 'YYYY-MM-dd')}|">13 February 2011</p>
    </div>
</div>
```
#### 선택변수표현식
```
<div class="panel-body" th:object="${user}">
    <span th:text="*{userName}">Sebastian</span>
</div>
```
***
## 리터럴
#### model 세팅
```
@GetMapping("/literals")
public String literalsForm(Model model) {
    Literal literal = new Literal();
    literal.setTrueValue(true);
    literal.setFalseValue(false);
    literal.setNullValue(null);
    /*사용자*/
    User user = new User();
    user.setUserId(2L);
    user.setUserName("chan");
    user.setUserEml("chan@naver.com");
    model.addAttribute("user", user);
    model.addAttribute("literal", literal);
    return "menu/literals";
}
```
#### Text literals
```
<li class="list-group-item text-danger" th:text="'working web application'"/>
```
#### Number literals
```
<li class="list-group-item">
    this year is <span class="text-danger" th:text="2022">9999</span>
</li>
```
#### Boolean literals
```
<li class="list-group-item" th:if="${literal.trueValue} == true">
    this is <span class="text-danger" th:text="${literal.trueValue}"></span>
</li>
<li class="list-group-item" th:if="${literal.falseValue} == false">
    this is <span class="text-danger" th:text="${literal.falseValue}"></span>
</li>
```
#### The null literal
```
<li class="list-group-item" th:if="${literal.nullValue} == null">
    this is <span class="text-danger" th:text="${literal.nullValue}"></span>
</li>
```
#### Appending texts
```
<li class="list-group-item text-danger" th:text="'this is Appending texts, ' + ${user.userName}"/>
```
#### Literal substitutions
```
<li class="list-group-item">
    <span class="text-danger" th:text="|this is literal substitutions, ${user.userName}|"/>
</li>
```
***
## Operations
#### model 세팅
```
@GetMapping("/operations")
public String operationsForm(Model model) {
    Operation operation = new Operation();
    operation.setAmCount(2);
    operation.setCpCount(3);
    operation.setCpMode("dev");
    model.addAttribute("operation", operation);
    return "menu/operations";
}
```
#### Arithmetic operations
```
<li class="list-group-item">
    <div class="text-danger" th:with="isEven=(${operation.amCount} % 2 == 0)">
        isEven=(${operation.amCount} % 2 == 0)
    </div>
</li>
```
#### Comparators and Equality
```
<li class="list-group-item">
    <div th:if="${operation.cpCount} &gt; 1">
        <span class="text-danger" th:text="'Execution mode is ' + ((${operation.cpMode} == 'dev') ? 'Developer' : 'Production')"/>
    </div>
</li>
```
***
## Conditional
#### model 세팅
```
@GetMapping("/conditional")
public String conditionalForm(Model model) {
    Conditional conditional = new Conditional();
    conditional.setEvenValue(2);
    conditional.setEvenBoolValue(true);
    User user = new User();
    user.setUserId(3L);
    user.setUserName("chan");
    model.addAttribute("conditional", conditional);
    model.addAttribute("user", user);
    return "menu/conditional";
}
```
#### Conditional expressions
```
<li class="list-group-item">
    <p th:class="(${conditional.evenValue} &gt; 1) ? 'text-primary' : 'text-danger'">th:class text-primary</p>
    <p th:class="${conditional.evenBoolValue} ? 'text-danger' : 'text-primary'" >th:class text-danger</p>
</li>
```
#### Default expressions (Elvis operator)
```
<li class="list-group-item">
    <div th:object="${user}">
        <p>Name : <span class="text-danger" th:text="*{userName} ?: '(no userName specified)'">no name</span></p>
        <p>Email : <span class="text-danger" th:text="*{userEml} ?: '(no userEml specified)'">no email</span></p>
    </div>
</li>
```
#### The No-Operation token
```
<li class="list-group-item">
    <div th:object="${user}">
        <p>MblCnpc : <span class="text-danger" th:text="*{userMblCpnc} ?: _">The No-Operation token</span></p>
    </div>
</li>
```
***
## Setting Attribute Values
#### model 세팅
```
@GetMapping("/attribute")
public String attributeForm(Model model) {
    Attribute attribute = new Attribute();
    attribute.setSubBtnText("Subscribe");
    model.addAttribute("attribute", attribute);
    return "menu/attribute";
}
```
#### Setting the value of any attribute
```
<li class="list-group-item">
    <form action="subscribe.html">
        <fieldset>
            <input type="text" name="email" />
            <input type="submit" value="Subscribe!" th:attr="value=${attribute.subBtnText}"/>
        </fieldset>
    </form>
</li>
```
#### Setting value to specific attributes
```
<li class="list-group-item">
    <form action="subscribe.html">
        <fieldset>
            <input type="text" name="email" />
            <input type="submit" value="Subscribe!" th:value="${attribute.subBtnText}"/>
        </fieldset>
    </form>
</li>
```
#### Setting more than one value at a time
```
<li class="list-group-item">
    <div class="row">
        <div class="col-xs-6 col-md-3">
            <a href="#" class="thumbnail">
                <img th:src="@{/images/temp.png}" th:alt="#{img.logo}">
            </a>
        </div>
    </div>
</li>
```
***
## Iteration
#### model 세팅
```
@GetMapping("/iteration")
public String iterationForm(Model model) {
    List<Prod> prods = createProds();
    model.addAttribute("prods", prods);
    return "menu/iteration";
}
```
#### Iteration basics
```
<tbody>
    <tr th:each="prod : ${prods}">
        <td th:text="${prod.getProdId()}">0</td>
        <td th:text="${prod.getProdName()}">Product</td>
        <td th:text="${prod.getProdAmt()}">0</td>
    </tr>
</tbody>
```
#### Keeping iteration status
```
<tbody>
    <tr th:each="prod, iterStat : ${prods}" th:class="${iterStat.odd} ? 'success'">
        <td th:text="${prod.getProdId()}">0</td>
        <td th:text="${prod.getProdName()}">Product</td>
        <td th:text="${prod.getProdAmt()}">0</td>
        <td th:text="${iterStat.index}">0</td>
        <td th:text="${iterStat.count}">0</td>
    </tr>
</tbody>
```
***
## Conditional Evaluation
#### model 세팅
```
@GetMapping("/conditionalEvaluation")
public String conditionalEvaluationForm(Model model) {
    List<Prod> prods = createProds();
    List<User> users = createUsers();
    model.addAttribute("prods", prods);
    model.addAttribute("users", users);
    return "menu/conditionalEvaluation";
}
```
#### Simple conditionals: “if” and “unless”
```
<tbody>
    <tr th:each="prod : ${prods}">
        <td th:text="${prod.getProdId()}">0</td>
        <td th:text="${prod.getProdName()}">Product</td>
        <td th:text="${prod.getProdAmt()}">0</td>
        <td>
            <span th:text="${#lists.size(prod.getComments())}">2</span> comment/s
            <a href="comments.html"
               th:href="@{/conditionalEvaluationComments(prodId = ${prod.getProdId()})}"
               th:if="${not #lists.isEmpty(prod.getComments)}">view</a>
        </td>
    </tr>
</tbody>
```
#### Switch statements
```
<tbody>
    <tr th:each="user : ${users}">
        <td th:switch="${#strings.toString(user.getUserRole())}">       <!--enum 타입 비교-->
            <span th:case="#{role.admin}" th:text="|${user.getUserName()}(${user.getUserId()}) is Admin|"></span>
            <span th:case="#{role.manager}" th:text="|${user.getUserName()}(${user.getUserId()}) is Manager|"></span>
            <span th:case="#{role.guest}" th:text="|${user.getUserName()}(${user.getUserId()}) is Guest|"></span>
        </td>
    </tr>
</tbody>
```
***
## Local Variables
#### model 세팅
```
@GetMapping("/localVariables")
public String localVariablesForm(Model model) {
    List<Prod> prods = createProds();
    model.addAttribute("prods", prods);
    model.addAttribute("today", Calendar.getInstance());

    return "menu/localVariables";
}
```
#### Local Variables
```
<li class="list-group-item">
    <div th:with="firstProd=${prods[0]}, secondProd=${prods[1]}">
        <p th:text="|first Product is ${firstProd.getProdName()}|"></p>
        <p th:text="|second Product is ${secondProd.getProdName()}|"></p>
    </div>
</li>
<li class="list-group-item">
    <div th:with="firstIndex=0, firstIndexProd=${prods[firstIndex]}">
        <p th:text="|firstIndex Product is ${firstIndexProd.getProdName()}|"></p>
    </div>
</li>
<li class="list-group-item">
    <div th:with="df=#{date.format}">
        <p th:text="|Today is ${#calendars.format(today, df)}|">2000-01-01</p>
    </div>
</li>
```
