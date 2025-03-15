use dian;
INSERT INTO user (username, email, password, status, created_at, update_time, del_flag)
VALUES
    ('john_doe', 'john@example.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'active', '2023-01-15 09:30:00', NOW(), 0),
    ('jane_smith', 'jane.smith@mail.com', '7c6a180b36896a0a8c027357c98a4923', 'active', '2023-02-20 14:15:00', NOW(), 0),
    ('alex_wong', 'awong@company.cn', 'd8578edf8458ce06fbc5bb76a58c5ca4', 'frozen', '2022-11-05 16:45:00', '2023-03-01 10:00:00', 0),
    ('emily_rose', 'emilyr@test.org', 'b0399d2029f64d445bd1312aa82a3d99', 'deleted', '2021-09-12 08:00:00', '2022-12-31 23:59:59', 1),
    ('mike2023', 'mike.li@service.io', '3b81b9c0d57b51dbb3feb1a7b530e7d3', 'active', NOW(), NOW(), 0),
    ('sara_connor', 'sara.c@sky.net', '9c9c1f36d8cae9a8695d24b4a39fc8e1', 'active', '2023-04-18 17:30:45', NOW(), 0),
    ('dev_robot', 'robot@devlab.com', '1a1dc91c907325c69271ddf0c944bc72', 'frozen', '2023-05-01 00:00:00', NOW(), 0),
    ('test_user8', 'testuser8@demo.com', 'd8b2a9f02b09736dca525bdacd4e4fd0', 'active', '2023-06-10 12:34:56', NOW(), 0),
    ('data_master', 'dm@bigdata.ai', '6c53051269aa5cdb3d8606f246bce7c4', 'active', '2023-07-22 20:45:30', NOW(), 0),
    ('cloud_admin', 'admin@cloud.org', 'e10adc3949ba59abbe56e057f20f883e', 'active', '2023-08-01 08:08:08', NOW(), 0);