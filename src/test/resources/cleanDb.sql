delete from gigs;
delete from band;
delete from venue;
delete from users;

INSERT INTO users VALUES (1, 'urchinthesky', '123')
                       , (2, 'SinnerAndSaint', '123')
                       , (3, 'peas123', '123')
                       , (4, 'pools', '123')
                       , (5, 'keggers', '123')
                       , (6, 'artinforever', '123');


INSERT INTO band VALUES (1, 'Sky Urchin', 'Madison, WI', 'Indie Rock', 'skyurchin@somewhere.com', 1)
    , (2, 'The Sinner and the Saint', 'Green Bay, WI', 'Punk', 'sinnerandsaint@somewhere.com', 2)
    , (3, 'Sweet Peas', 'Madison, WI', 'Neo Soul', 'sweetpeas@somewhere.com', 3);


INSERT INTO venue VALUES (1, 'Pooleys', '5441 High Crossing Blvd, Madison, WI 53718', 'Outdoor Patio', 'pooleys@somewhere.com', 4)
                       , (2, 'Keggers', '231 N Broadway, Green Bay, 54303', 'Indoor small raised stage', 'keggers@somewhere.com', 5)
                       , (3, 'Art In', '1444 E Washington Ave, Madison, WI 53703', 'Indoor performance room', 'artin@somewhere.com', 6);

INSERT INTO gigs VALUES (1, 1, 3, '2021-05-13', '08:00')
                      , (2, 1, 1, '2021-06-17', '08:30')
                      , (3, 2, 2, '2021-04-25', '07:30')
                      , (4, 3, 1, '2021-05-20', '08:00');