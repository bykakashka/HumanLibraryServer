insert into City (id, name_en) values (1, 'minsk');

insert into Event (id, date, city_id, address, title, descr, status, info, name) values (1, '02-11-2020', 1, 'test address', 'title', 'descr', 'PUBLISHED', 'Мерапрыемства адбудзецца ў прасторы Lo-Fi Customs (вул. Кастрычніцкая 16/3, ул. Октябрьская 16/3). Гэта доўгі будынак уздоўж Свіслачы, у якім мы будзем у самым канцы - апошнія дзверы, 2 паверх. Будуць указальнікі на ўік-энд "Розныя-Роўныя" - трэба арыентавацца па ім. Мапа ад метро ў дадатку.


Жывая Бібліятэка будзе з 14:45 да 19:00, але запрашаем вас раней на лекцыю і адкрыццё ўік-энду "Розныя роўныя" у 13:00, а пасля Жывой Бібліятэка на канцэрт у 20:00.


Па спасылцы http://bit.ly/katalogknig вы знойдзеце поўны каталог "Жывых Кніг" заўтрашняга мерапрыемства. Канешне, ён можа змяняцца, бо ўсе мы людзі. Каб прачытаць як мага болей Кніг, вам трэба прыйсці к самаму пачатку! Але каб не ствараць чэргі і не затрымліваць працэс, раім вам прыходзіць на 5-10 хвілін раней! Вы ўжо зарэгістраваліся, а таму вам патрэбна будзе ўзяць толькі картку чытача_кі на стойке рэгістрацыі са сваім нумарам. Для тых, хто прыйдзе да нас першы раз мы раім для прагляду відэа на галоўнай старонцы нашага сайту http://humanlibrary.by/ - праз яго вы адчуеце атмасферу і крыху больш зразумееце сам працэс. Таксама мы падрыхтавалі для вас інструкцыю па тым, што рабіць, калі вы ў нас першы раз. Шукайце яе ў дадатку. Нагадваем усім правілы мерапрыемства! (глядзі дадатак)


П.с. Яшчэ раім вам узяць з сабой, калі ў вас ёсць, свой тэрма-кубак - так вы заўжды будзеце са сваёй кавай/гарбатай. Давайце будзем больш экапрыязнымі разам! :)', 'Живая библиотека в минске');
insert into Event (id, date, city_id, address, title, descr, status) values (2, '02-11-2021', 1, 'test address', 'title', 'descr', 'NEW');
insert into Event (id, date, city_id, address, title, descr, status) values (3, '02-11-2018', 1, 'test address', 'title', 'descr', 'NEW');

insert into users(nickname, pass) values ('byka', '$2a$10$d/JqO06hWkCDYzHmvmfN/uw3ia5yd9tXWtI4lRjCez1KRmVPGpr4G');
insert into users(nickname, pass) values ('test1', '$2a$10$d/JqO06hWkCDYzHmvmfN/uw3ia5yd9tXWtI4lRjCez1KRmVPGpr4G');
insert into users(nickname) values ('test2');
insert into users(nickname) values ('test3');
insert into users(nickname) values ('test4');

insert into user_role(user_id, role) VALUES (1, 'ROLE_BOOK');
insert into user_role(user_id, role) VALUES (1, 'ROLE_ADMIN');
insert into user_role(user_id, role) VALUES (1, 'ROLE_READER');
insert into user_role(user_id, role) VALUES (2, 'ROLE_READER');

insert into Book(name, short_descr, long_descr) values ('Мама модели с синдромом Дауна', 'short descr', 'Синдро́м Да́уна (трисомия по хромосоме 21) — одна из форм геномной патологии, при которой чаще всего кариотип представлен 47 хромосомами вместо нормальных 46, поскольку хромосомы 21-й пары, вместо нормальных двух, представлены тремя копиями (см. также плоидность). Существует ещё две формы данного синдрома: транслокация хромосомы 21 на другие хромосомы (чаще — на 15, реже — на 14, ещё реже — на 21, 22 и Y-хромосому) — 4 % случаев, и мозаичный вариант синдрома — 5 %.

Синдром получил название в честь английского врача Джона Дауна, впервые описавшего его в 1866 году. Связь между происхождением врождённого синдрома и изменением количества хромосом была выявлена только в 1959 году французским генетиком Жеромом Леженом. В русском молодёжном сленге «даунами» пренебрежительно называют просто глупых людей[1][2].

Слово «синдром» означает набор признаков или характерных черт. При употреблении этого термина предпочтительнее форма «синдром Дауна», а не «болезнь Дауна»[3].

Первый Международный день человека с синдромом Дауна был проведён 21 марта 2006 года по инициативе греческого генетика Стилианоса Антонаракиса из Женевского университета. День и месяц были выбраны в соответствии с номером пары и количеством хромосом. ');
insert into Book(name, short_descr, long_descr) values ('Феминистка', 'short descr', 'Фемини́зм (от лат. femina «женщина») — спектр идеологий, политических и социальных движений, направленных на достижение равенства политических, экономических, личных и социальных прав для женщин[1][2] или преодоление сексизма[3].

Феминистские движения и в прошлом, и в настоящем борются за права женщин: избирательное право, право занимать государственные должности, право на труд и равную оплату труда, право на собственность, образование, участие в сделках, равные права в браке, право на отпуск по беременности и родам, право на телесную автономию и неприкосновенность (защита женщин и девочек от изнасилований, сексуальных домогательств и домашнего насилия)[4]. Феминистские движения считаются одной из главных движущих сил крупнейших социальных изменений в области прав женщин, особенно в западных странах, где их деятельность почти единогласно признаётся причиной таких достижений как женское избирательное право, женские репродуктивные права (доступ к средствам контрацепции, право на аборт), право заключать сделки и обладать собственностью и гендерная нейтральность словоупотребления в английском языке[5]. ');
insert into Book(name, short_descr, long_descr) values ('Квир', 'short descr', 'Квир (англ. queer) — собирательный термин, используемый для обозначения сексуальных и гендерных меньшинств, не соответствующих гетеросексуальной или цисгендерной идентичности. Изначально имевшее значение «странный» или «своеобразный», слово квир использовалось в качестве оскорбления людей, которые испытывали влечение к людям своего пола или имели с ними отношения. С конца 1980-х годов учёные и активисты начали «отвоёвывание» слова для создания сообщества и утверждения новой идентичности, отдельной от гей-идентичности. Люди, отвергающие традиционные гендерные идентичности и ищущие альтернативу акрониму ЛГБТ, могут называть себя квирами.

Квир также часто используется для описания ненормативных (то есть анти-гетеронормативных и анти-гомонормативных) идентичностей и убеждений[1]. Такие академические дисциплины, как квир-теория и квир-исследования, совместно противодействуют бинаризму, нормативности и недостатку интерсекциональности внутри мейнстримного ЛГБТ-сообщества.

Термин часто подвергается критике со стороны членов ЛГБТ-сообщества, а также других людей, ассоциирующих слово с его разговорным использованием в качестве оскорбления или желающих отделить себя от квир-радикализма. ');
insert into Book(name, short_descr, long_descr) values ('Госопжа', 'short descr', 'ГОСПОЖА
    Форма женского рода от слова господин, а также — вежливое обращение при фамилии или звании женщины, независимо от ее социальной или национальной принадлежности. Форма множественного числа — дамы. Однако при обращении к группе лиц обоего пола употребляется только слово господа, а обращение дамы и господа!, которое довольно часто звучит в публичной речи, является неправильным.

    Слово госпожа никогда не употребляется при имени. В сочетании с указательным местоимением эта приобретает иронический или пренебрежительный оттенок. Если за словом госпожа следует не конкретная фамилия или звание определенного лица, а что-либо другое, это указывает на неизвестность человека (госпожа в автомобиле).');
insert into Book(name, short_descr, long_descr) values ('Буддист', 'short descr', 'Будди́зм (санскр. बुद्ध धर्म, buddha dharma IAST; пали बुद्ध धम्म, buddha dhamma, «Учение Просветлённого»[1]; кит. 佛教 fójiào) — религиозно-философское учение (дхарма) о духовном пробуждении (бодхи), возникшее в середине 1-го тысячелетия до н. э. в Древней Индии. Основателем учения считается Сиддхартха Гаутама, впоследствии получивший имя Будда Шакьямуни[2].

Сами последователи этого учения называли его «Дхарма» (Закон, Учение) или «Буддхадхарма» (Учение Будды). Термин «буддизм» был создан европейцами в XIX веке[3]. Различные исследователи определяли буддизм по-разному, — как религию, философию, этическое учение, культурную традицию, цивилизацию, образование[4], как «науку о сознании»[5][6][4].

Буддизм — мировая религия, признанная многочисленными народами с разными традициями. По замечанию Е. А. Торчинова, «Без понимания буддизма невозможно понять и великие культуры Востока — индийскую, китайскую, не говоря уж о культурах Тибета и Монголии, пронизанных духом буддизма до их последних оснований»[3]. ');
insert into Book(name, short_descr, long_descr) values ('Буддист', 'short descr', 'Будди́зм (санскр. बुद्ध धर्म, buddha dharma IAST; пали बुद्ध धम्म, buddha dhamma, «Учение Просветлённого»[1]; кит. 佛教 fójiào) — религиозно-философское учение (дхарма) о духовном пробуждении (бодхи), возникшее в середине 1-го тысячелетия до н. э. в Древней Индии. Основателем учения считается Сиддхартха Гаутама, впоследствии получивший имя Будда Шакьямуни[2].

Сами последователи этого учения называли его «Дхарма» (Закон, Учение) или «Буддхадхарма» (Учение Будды). Термин «буддизм» был создан европейцами в XIX веке[3]. Различные исследователи определяли буддизм по-разному, — как религию, философию, этическое учение, культурную традицию, цивилизацию, образование[4], как «науку о сознании»[5][6][4].

Буддизм — мировая религия, признанная многочисленными народами с разными традициями. По замечанию Е. А. Торчинова, «Без понимания буддизма невозможно понять и великие культуры Востока — индийскую, китайскую, не говоря уж о культурах Тибета и Монголии, пронизанных духом буддизма до их последних оснований»[3]. ');
insert into Book(name, short_descr, long_descr) values ('Анархист', 'short descr', 'Анархи́зм (от ἀν – без и ἄρχή – власть) — общее наименование ряда систем взглядов, основывающихся на человеческой свободе и отрицающих необходимость управления обществом с помощью государства.[1]

Существует множество различных направлений анархизма, которые часто расходятся в тех или иных вопросах: от второстепенных, и вплоть до основополагающих (в частности — относительно взглядов на частную собственность, рыночные отношения, этнонациональный вопрос).

Анархисты выступают за самоуправление, то есть за систему независимых собраний граждан, самостоятельно управляющих своей жизнью и трудом на рабочем месте, в районе проживания и т. д. Анархистское общество представляет собой добровольную конфедерацию таких собраний.

Анархисты отрицают полезность подавления одних людей другими и привилегии одних участников общественного процесса по отношению к другим, предлагая заменить любые механизмы государственного принуждения свободным сотрудничеством индивидов. По мнению анархистов, общественные отношения должны основываться на личной заинтересованности, добровольном согласии и ответственности каждого участника. ');
insert into Book(name, short_descr, long_descr) values ('Бывшая наркоманка', 'short descr', '«Все утром пили кофе, а мы принимали дозу»: бывшая наркоманка о том, как избавилась от зависимости, живет с ВИЧ и помогает другим бороться
Глядя на жизнерадостную Дарью,* не скажешь, что она 12 лет употребляла наркотики. Аккуратно уложенные волосы, легкий макияж и стильная одежда... Даша заваривает чай и поднимает глаза – большие и серые, они многое повидали в жизни.');
insert into Book(name, short_descr, long_descr) values ('Усыновленная', 'short descr', 'сыновле́ние, удочере́ние — форма семейного воспитания детей, лишённых родительской опеки, с установлением между усыновленным и усыновителем правовых (личных и имущественных) отношений, существующих между родителями и детьми[1].

По российскому праву усыновление допускается только в отношении несовершеннолетних детей[1]. Усыновление производится судом по заявлению лиц, желающих усыновить ребёнка, в порядке особого производства по правилам гражданского процессуального законодательства[2].

Усыновление (удочерение) в России регламентировано Семейным кодексом Российской Федерации.

В соответствии с п.4 ст 124 СК РФ Усыновление детей, являющимися гражданами Российской Федерации иностранными гражданами возможно только по истечении двенадцати месяцев со дня поступления сведений о таких детях в Государственный банк данных о детях.

10 января 2019 года стало известно, что Минпросвещения[3] ужесточает правила усыновления и опеки. В случае принятия закон вступит в силу 1 января 2021 года, наложит запрет на усыновление более одного ребенка в год и введет обязательное психологическое обследование всех совершеннолетних членов приемных семей. При этом по решению Конституционного суда будет снят жесткий запрет на усыновление детей ВИЧ-инфицированными. ');
insert into Book(name, short_descr, long_descr) values ('Фотограф', 'short descr', 'Фото́граф — человек, создающий фотографии[1][2][3] при помощи фотоаппарата.

Работа фотографа в узком смысле представляет собой непосредственно фотосъёмку. В широком смысле фотограф — человек, в чьи задачи входит подготовка к проведению съёмок (выбор темы, переговоры, получение разрешений и согласований, подбор моделей, реквизита, оборудования, выбор места и т. п.), непосредственно фотосъёмка и последующая работа по обработке и печати фотографий, продажа материала. В ряде случаев часть этих работ фотограф передает своим ассистентам, помощникам, визажистам, художникам по костюмам, агентам, осветителям, гримёрам и другим людям[4]. ');
insert into Book(name, short_descr, long_descr) values ('Бывший заключенный', 'short descr', 'ывший заключенный, который в рамках испытательного срока работал в здании суда в Анкаре, был арестован после того, как в присутствии судьи из его кармана выпали наркотики.

Как сообщается, таблетки выпали, когда заключенный Серкан А. принес в кабинет судьи чай.

Серкан А. был принят на работу в суд Анкары в рамках программы трудоустройства для бывших заключенных.

Действуя по наводке судьи, полиция проследила за подозреваемым и обнаружила его тайник с наркотиками в одном из туалетов в здании суда.

После проведенного прокурорами допроса Серкан А. был арестован и доставлен в тюрьму Синджан');
insert into Book(name, short_descr, long_descr) values ('Лесби-пара', 'short descr', 'Миранда Хоббс — героиня Синтии Никсон в сериале «Секс в большом городе» — была самой скромной из четверки подруг. А сама актриса пятнадцать лет жила с Дэнни Мозесом, родив с ним двух детей, но потом вдруг променяла его на активистку Кристин Маринони.

В 2009 году лесби-пара объявила о своей помолвке, а в 2012 сыграла свадьбу. Сегодня Синтия и Кристин растят трех детей: Саманту и Чарльза (от прошлого брака Никсон) и Макса Эллингтона, которого Кристин родила в 2011 году.');


insert into event_book(book_id, event_id) values (1, 1);
insert into event_book(book_id, event_id) values (2, 1);
insert into event_book(book_id, event_id) values (3, 1);
insert into event_book(book_id, event_id) values (4, 1);
insert into event_book(book_id, event_id) values (5, 1);
insert into event_book(book_id, event_id) values (6, 1);
insert into event_book(book_id, event_id) values (7, 1);
insert into event_book(book_id, event_id) values (8, 1);
insert into event_book(book_id, event_id) values (9, 1);
insert into event_book(book_id, event_id) values (10, 1);
insert into event_book(book_id, event_id) values (11, 1);
insert into event_book(book_id, event_id) values (12, 1);

insert into session(id, sequence, event_id, start_date, end_date) values (1, 1, 1, '02-11-2020 14:45:00', '02-11-2020 15:05:00');
insert into session(id, sequence, event_id, start_date, end_date) values (2, 2, 1, '02-11-2020 15:15:00', '02-11-2020 15:35:00');
insert into session(id, sequence, event_id, start_date, end_date) values (3, 3, 1, '02-11-2020 15:15:00', '02-11-2020 16:05:00');
insert into session(id, sequence, event_id, start_date, end_date) values (4, 4, 1, '02-11-2020 16:15:00', '02-11-2020 16:35:00');
insert into session(id, sequence, event_id, start_date, end_date) values (5, 5, 1, '02-11-2020 17:00:00', '02-11-2020 17:25:00');

-- TODO deprecated>
insert into book_session (book_id, session_id) values (1, 1);
insert into book_session (book_id, session_id) values (2, 1);
insert into book_session (book_id, session_id) values (3, 1);
insert into book_session (book_id, session_id) values (4, 1);
insert into book_session (book_id, session_id) values (5, 1);


insert into board(board_no, max_users, book_id, session_id) values (1, 10, 1, 1);
insert into board(board_no, max_users, book_id, session_id) values (2, 10, 2, 1);
insert into board(board_no, max_users, book_id, session_id) values (3, 10, 3, 1);
insert into board(board_no, max_users, book_id, session_id) values (4, 10, 4, 1);
insert into board(board_no, max_users, book_id, session_id) values (5, 10, 5, 1);
insert into board(board_no, max_users, book_id, session_id) values (6, 10, 6, 1);
insert into board(board_no, max_users, book_id, session_id) values (7, 10, 7, 1);
insert into board(board_no, max_users, book_id, session_id) values (8, 10, 8, 1);
insert into board(board_no, max_users, book_id, session_id) values (9, 10, 9, 1);

insert into board(board_no, max_users, book_id, session_id) values (1, 10, 5, 2);
insert into board(board_no, max_users, book_id, session_id) values (2, 10, 7, 2);
insert into board(board_no, max_users, book_id, session_id) values (3, 10, 2, 2);
insert into board(board_no, max_users, book_id, session_id) values (4, 10, 1, 2);
insert into board(board_no, max_users, book_id, session_id) values (5, 10, 10, 2);
insert into board(board_no, max_users, book_id, session_id) values (6, 10, 11, 2);
insert into board(board_no, max_users, book_id, session_id) values (7, 10, 12, 2);
insert into board(board_no, max_users, book_id, session_id) values (8, 10, 9, 2);
insert into board(board_no, max_users, book_id, session_id) values (9, 10, 4, 2);

insert into board(board_no, max_users, book_id, session_id) values (1, 10, 1, 3);
insert into board(board_no, max_users, book_id, session_id) values (2, 10, 2, 3);
insert into board(board_no, max_users, book_id, session_id) values (3, 10, 3, 3);
insert into board(board_no, max_users, book_id, session_id) values (4, 10, 6, 3);
insert into board(board_no, max_users, book_id, session_id) values (5, 10, 8, 3);
insert into board(board_no, max_users, book_id, session_id) values (6, 10, 9, 3);
insert into board(board_no, max_users, book_id, session_id) values (7, 10, 4, 3);
insert into board(board_no, max_users, book_id, session_id) values (8, 10, 7, 3);
insert into board(board_no, max_users, book_id, session_id) values (9, 10, 10, 3);

insert into board(board_no, max_users, book_id, session_id) values (1, 10, 3, 4);
insert into board(board_no, max_users, book_id, session_id) values (2, 10, 4, 4);
insert into board(board_no, max_users, book_id, session_id) values (3, 10, 6, 4);
insert into board(board_no, max_users, book_id, session_id) values (4, 10, 8, 4);
insert into board(board_no, max_users, book_id, session_id) values (5, 10, 12, 4);
insert into board(board_no, max_users, book_id, session_id) values (6, 10, 10, 4);
insert into board(board_no, max_users, book_id, session_id) values (7, 10, 11, 4);

insert into board(board_no, max_users, book_id, session_id) values (1, 10, 8, 5);
insert into board(board_no, max_users, book_id, session_id) values (2, 10, 7, 5);
insert into board(board_no, max_users, book_id, session_id) values (3, 10, 6, 5);
insert into board(board_no, max_users, book_id, session_id) values (4, 10, 4, 5);
insert into board(board_no, max_users, book_id, session_id) values (5, 10, 5, 5);
insert into board(board_no, max_users, book_id, session_id) values (6, 10, 2, 5);
insert into board(board_no, max_users, book_id, session_id) values (7, 10, 10, 5);


insert into Media(id, url, name) values (1, 'https://images.pexels.com/photos/67636/rose-blue-flower-rose-blooms-67636.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'test image');
insert into Media(id, url, name) values (2, 'https://images.pexels.com/photos/414612/pexels-photo-414612.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'test image 2');

insert into News(title, text, creation_date, author_id) values ('Сёння Дзень народзінаў святкуе каардынатарка Жывых Бібліятэк у Мінску Ганна Марзан', 'this is test text', '02-11-2019 15:15:00', 1);
insert into News(title, text, creation_date, author_id) values ('Жывая Бібліятэка зусім хутка', 'Мы гатовыя, а вы? Яшчэ трэба пазнаёміцца з астатняй часткай Жывых Кніг, з якімі можна будзе пагутарыць 16 сакавіка.

А зарэгістравацца можна тут: http://goo.gl/eY7yie

Чакаем усіх заўтра ў 14:45 у прасторы Lo-fi

Жывыя Кнігі. Частка 3.', '02-12-2019 15:15:00', 1);
insert into News(text, creation_date, author_id) values ('

I am creating a website to record video using webcam. I can successfully download videos to my local computer. But what I want is to pass the data to the backend and save the min AWS S3 bucket. I tried to send the recordedblob to backend and save it to .mp4 file or .webm file. But I can''t play them after downloading from s3 bucket. I also tried to open the mp4 file uisng hex editor, copy the content, paste in a empty file and name it test.mp4. Then I found the size of new file is different and I can''t play it with player. I am wondering what''s right way to pass streaming video data. Thanks.

My code to download video locally and send to backend using API gateway. ', '02-13-2019 15:15:00', 1);
insert into News(text, creation_date, author_id) values ('Any thoughts? Is this a bug or something I''m just not doing right?Any thoughts? Is this a bug or something I''m just not doing right?Any thoughts? Is this a bug or something I''m just not doing right?Any thoughts? Is this a bug or something I''m just not doing right?Any thoughts? Is this a bug or something I''m just not doing right?Any thoughts? Is this a bug or something I''m just not doing right?Any thoughts? Is this a bug or something I''m just not doing right?Any thoughts? Is this a bug or something I''m just not doing right?Any thoughts? Is this a bug or something I''m just not doing right?Any thoughts? Is this a bug or something I''m just not doing right?Any thoughts? Is this a bug or something I''m just not doing right?Any thoughts? Is this a bug or something I''m just not doing right?Any thoughts? Is this a bug or something I''m just not doing right?Any thoughts? Is this a bug or something I''m just not doing right?Any thoughts? Is this a bug or something I''m just not doing right?Any thoughts? Is this a bug or something I''m just not doing right?Any thoughts? Is this a bug or something I''m just not doing right?Any thoughts? Is this a bug or something I''m just not doing right?', '02-14-2019 15:15:00', 1);

insert into NEWS_MEDIA(media_Id, news_Id) values (1, 1);
insert into NEWS_MEDIA(media_Id, news_Id) values (2, 2);

insert into info_page(type, text)  values ('ABOUT', 'we are very cool');
insert into info_page (type, text) values ('RULES', 'Что делать, когда ты пришёл на Живую Библиотеку в первый раз?


«Живая библиотека» - это необычная библиотека, тут вместо привычных нам книг, выступают живые люди со своими историями, которые готовы отвечать на любые вопросы. «Живая Книга» - это живой человек, который имеет определенную идентичность, редкую профессию, уникальный опыт, непривычный для некоторых образ жизни или мировоззрение. «Живая Книга» - это Другой. Это тот, кто хоть чем-то он вас отличается, тот, кто помогает нам смотреть на мир под другим углом.


У нас есть три основных важных правила:


1. Необходимо с уважением относиться к любому мнению. Вам не обязательно его разделять или принимать, но вам важно понимать, что человек имеет право на мнение отличное от вашего. А это значит, что не стоит вступать в агрессивные споры по этому поводу. Взаимоуважение – основа конструктивного общения как на Живой Библиотеке, так и в жизни.


2. Вы можете задавать Книгам любые интересующие вас вопросы. Однако Книга вправе не отвечать на любой вопрос по личным причинам (он может быть слишком личным, неуместным или даже оскорбительным для Книги). Уважайте, пожалуйста, право Книги на молчание. Не забывайте, также, что не только у вас есть вопросы – дайте их задать и другим читателям.


3. Читатели должны возвращать Книгу в том же моральном, психическом и физическом состоянии, в каком ее взяли. Это важно для сохранности наших героев-Книг и их доброго самочувствия во время и после мероприятия.


Время проведения мероприятия разделено на несколько условных «сессий» (это отрезок времени около 30 минут). Во время одной такой сессии одновременно в разных местах помещения беседу ведут 5-10 Книг (зависит от размера помещения, количества книг и т.д.). В течение одной сессии можно «прочитать» только одну Книгу, за всю библиотеку – от 5 и более (зависит от продолжительности мероприятия). НЕЛЬЗЯ менять «книгу» во время сессии – это может нарушить всю магию совместного общения и всё придётся начинать заново, а время ограничено. Беседа происходит в группе до 8 человек. Пожалуйста, если библиотекари не записали вас к Книге по причине того, что места закончились – уважайте это! Мы делаем Живые Библиотеки уже более 2,5 лет и абсолютно уверены, что для настоящего общения и знакомства даже 8 человек – это уже многовато. А в Библиотеке невероятна важна коммуникация, важно, чтобы люди успели задать волнующие их вопросы. Чем меньше людей на сессии, тем больше каждый сможет включиться в разгово
');
insert into info_page (type, text) values ('JOIN_VOLUNTEER', 'Стать волонтером');
insert into info_page (type, text) values ('JOIN_ORG', 'Стать организатором');
insert into info_page (type, text) values ('CONTACTS_SUPPORT', 'Поддержать');