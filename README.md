# Лаборатори 09 — JaCoCo ашиглан кодын хамралт хэмжих

Оюутны нэр: Г. Саранчимэг
Оюутны код: B232274001

## А хэсэг — Үндсэн үйлдлийн тестүүд

Эхний таван JUnit тестээр үндсэн амжилттай үйлдлүүдийг шалгасан. Эхний хувилбарын тайлангаар 25 мөрөөс 14 мөр буюу **56%**, 41 салааллаас 18 буюу **43.9%** хамрагдсан ([results/mvn-verify-A.txt](results/mvn-verify-A.txt), [results/jacoco-A.csv](results/jacoco-A.csv)). JaCoCo-ийн тайлан дахь **шар мөрүүд** нь тухайн мөрийн зарим салаа ажилласныг, **улаан мөрүүд** нь огт ажиллаагүй мөр/салаа байсныг харуулсан. Ялангуяа буруу оролтын шалгалт, бага үнэлгээний зам, тэтгэлгийн бусад хэмжээнүүд шар/улаанаар үлдсэн тул нэмэлт тест шаардлагатай байсан.

## B хэсэг — CFG ба 100% branch хамралт

[cfg.png](cfg.png) зурагт зөвхөн scholarship() функцийн CFG-г үзүүлсэн. CFG-ийн **ирмэг бүрийн T/F шошгоны ард тухайн ирмэгийг дайрдаг тестийн методын нэр** бичигдсэн; letterGrade-ийн тестүүдийг энэ зурагт оруулаагүй. Иймээс нэрс нь ерөнхий жагсаалт биш, тодорхой T/F ирмэгтэй шууд холбогдоно.

Нэмэлт тестүүдээр бүх буруу оролтын exception, hasViolation-ийн хоёр салаа, 100/70/50/0 тэтгэлгийн буцаалт, мөн богино залгаатай нөхцөлүүдийг шалгасан. [results/mvn-verify-B.txt](results/mvn-verify-B.txt)-д 9 тест амжилттай, [results/jacoco-B.csv](results/jacoco-B.csv)-д BRANCH_MISSED=0, LINE_MISSED=0 байна.

## C хэсэг — Хязгаарын утгын тестүүд

gpa() функцийн массивын хэмжээнээс хамаарах дараах тохиолдлуудыг тусад нь шалгасан:

- 0 утга: хоосон массив IllegalArgumentException шиднэ;
- 1 утга: gpa([95]) == 4.0;
- 2 ба түүнээс олон утга: gpa([95, 85, 75, 65]) == 2.5.

Мөн null массив, бүх үнэлгээний муж болон дундаж тооцооллыг шалгасан.

## D хэсэг — Спецификацийн алдааг илрүүлж зассан нь

letterGradeCoversAllGradeRangesAndInvalidScores тест [ScholarshipCalculatorTest.java](src/test/java/mn/edu/must/sqat/ScholarshipCalculatorTest.java)-ийн **41-р мөрөнд** letterGrade(60)-г D байх ёстой гэж шалгасан. Засварын өмнөх ажиллуулалтын үр дүнд expected: <D> but was: <F> гэсэн алдаа гарсан бөгөөд энэ нь [results/mvn-test-D-fail.txt](results/mvn-test-D-fail.txt)-д хадгалагдсан. Шалтгаан нь production кодын score > 60 нөхцөл 60 оноог D биш F болгож байсан явдал. Нөхцөлийг score >= 60 болгон зассанаар заагийн утга зөв ангилагдсан. Гэхдээ 100% branch хамралт нь зөвхөн нөхцөл бүрийн T/F замыг ажиллуулсан гэсэн үг бөгөөд oracle/спецификацийн зөв утгыг дангаараа батлахгүй. Тиймээс тусгай boundary assertion нь семантик алдааг илрүүлсэн.

a298395 commit-д “засвар тусдаа commit” гэж бичих боломжгүй бодит бүтэцтэй: README, CFG, results-ийн файлууд, production код болон тест нийлээд **8 файл нэг commit-д** орсон. Иймээс энэ тайлан бодит түүхийг дээрхээр нь засаж тайлбарласан.

Эцсийн үр дүнгээр 12 тест бүгд амжилттай, JaCoCo BRANCH_MISSED=0, LINE_MISSED=0 болсон ([results/mvn-verify-final.txt](results/mvn-verify-final.txt), [results/jacoco-final.csv](results/jacoco-final.csv)).

## Ашигласан файлууд

- results/mvn-verify-A.txt — A хэсгийн Maven гаралт;
- results/jacoco-A.csv — A хэсгийн JaCoCo хүснэгт;
- results/mvn-verify-B.txt — B хэсгийн Maven гаралт;
- results/jacoco-B.csv — B хэсгийн JaCoCo хүснэгт;
- results/mvn-test-D-fail.txt — D засварын өмнөх унасан тестийн гаралт;
- results/mvn-verify-final.txt — эцсийн Maven гаралт;
- results/jacoco-final.csv — эцсийн JaCoCo хүснэгт.

## AI ашигласан тухай

JUnit тестүүдийг зохион байгуулах, JaCoCo-ийн CSV гаралтыг тайлбарлах, CFG болон README-г бэлтгэхэд AI тусламж ашигласан. Кодыг локал орчинд ажиллуулж, унасан boundary тест болон эцсийн mvn verify үр дүнг тусад нь шалгасан.
