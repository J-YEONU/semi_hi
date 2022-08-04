<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="path" value="${ pageContext.request.contextPath }" />

<!-- <link rel="stylesheet" href="${ path }/resources/css/view.css" /> -->
<link rel="stylesheet" href="${ path }/resources/css/home.css" />

<main>
  <div
    id="carouselExampleIndicators"
    class="carousel slide"
    data-bs-ride="carousel"
  >
    <div class="carousel-indicators">
      <button
        type="button"
        data-bs-target="#carouselExampleIndicators"
        data-bs-slide-to="0"
        class="active"
        aria-current="true"
        aria-label="Slide 1"
      ></button>
      <button
        type="button"
        data-bs-target="#carouselExampleIndicators"
        data-bs-slide-to="1"
        aria-label="Slide 2"
      ></button>
      <button
        type="button"
        data-bs-target="#carouselExampleIndicators"
        data-bs-slide-to="2"
        aria-label="Slide 3"
      ></button>
    </div>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img
          src="${ path }/resources/images/Hi_Main.png"
          class="d-block w-100"
          alt="..."
          style="width: 100%; height: 800px"
        />
      </div>
      <div class="carousel-item">
        <img
          src="${ path }/resources/images/Hi_Banner.png"
          class="d-block w-100"
          alt="..."
          style="width: 100%; height: 800px"
        />
      </div>
      <!-- <div class="carousel-item">
        <img src="..." class="d-block w-100" alt="..." />
      </div> -->
    </div>
    <button
      class="carousel-control-prev"
      type="button"
      data-bs-target="#carouselExampleIndicators"
      data-bs-slide="prev"
    >
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Previous</span>
    </button>
    <button
      class="carousel-control-next"
      type="button"
      data-bs-target="#carouselExampleIndicators"
      data-bs-slide="next"
    >
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </button>
  </div>
  <main>
    <section class="py-5 text-center container">
      <div class="row py-lg-5" id="myStudyType">
        <div class="col-lg-6 col-md-8 mx-auto">
          <h1>Hi(An-Mozilla) <br />스터디</h1>
        </div>
      </div>
    </section>

    <div class="album py-5" style="margin-bottom: 0">
      <div class="container">
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
          <c:if test="${ empty list }">
            <span
              >지금 바로 <b>당신의 스터디</b>를 시작해주세요 !!!!!!!!!!</span
            >
          </c:if>

          <!-- .col 스터디 카드 하나! -->
          <c:if test="${ ! empty list }">
            <c:forEach var="board" items="${ list }">
              <div class="col" id="studyBox">
                <a
                  onclick="location.href='${ path }/sboard/view?no=${ board.SNo }'"
                  style="text-decoration: none; cursor: pointer"
                >
                  <div class="studyContent">
                    <div
                      class="bd-placeholder-img card-img-top"
                      xmlns="http://www.w3.org/2000/svg"
                      role="img"
                      aria-label="Placeholder: Thumbnail"
                      preserveAspectRatio="xMidYMid slice"
                      focusable="false"
                    >
                      <div class="studyStart">${ board.SDate }</div>
                      <div class="studyTitle">${ board.STitle }</div>

                      <div class="studyFilter">
                        <div class="testNo">
                          <c:if test="${ board.language.LNo != 4 }">
                            <img
                              src="${ path }/resources/images/Test_logo/${ board.test.testType }.png"
                              alt="${ path }/resources/images/Test_logo/basic.png"
                              class="testImg"
                            />
                          </c:if>
                          <c:if test="${ board.language.LNo == 4 }">
                            <img
                              src="${ path }/resources/images/Test_logo/basic.png"
                              class="testImg"
                            />
                          </c:if>
                        </div>
                        <div class="sLevel">
                          <c:choose>
                            <c:when test="${ board.SLevel == '초급' }">
                              <img
                                src="${ path }/resources/images/level.png"
                                class="levelImg"
                              />
                            </c:when>
                            <c:when test="${ board.SLevel == '중급' }">
                              <img
                                src="${ path }/resources/images/level.png"
                                class="levelImg"
                              />
                              <img
                                src="${ path }/resources/images/level.png"
                                class="levelImg"
                              />
                            </c:when>
                            <c:when test="${ board.SLevel == '고급' }">
                              <img
                                src="${ path }/resources/images/level.png"
                                class="levelImg"
                              />
                              <img
                                src="${ path }/resources/images/level.png"
                                class="levelImg"
                              />
                              <img
                                src="${ path }/resources/images/level.png"
                                class="levelImg"
                              />
                            </c:when>
                          </c:choose>
                        </div>
                      </div>
                      <div class="writerInfo">
                        <img
                          src="${ path }/resources/images/Hi_Profil.png"
                          class="writerImg"
                        />
                        <div class="writerNick">${ board.member.nickName }</div>
                      </div>
                    </div>
                  </div>
                </a>
              </div>
            </c:forEach>
          </c:if>
        </div>
        <!-- .col 스터디 카드 하나! -->
      </div>
    </div>
  </main>
</main>