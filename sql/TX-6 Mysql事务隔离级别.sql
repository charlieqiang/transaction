begin;
INSERT INTO transaction_base_prd.base_info (base_id, base_code, creator_id, creator, create_time, modifier_id, modifier,
                                            last_modify_time, deleted, record_version)
VALUES (1088586123853258765, '3', null, null, '2023-03-23 22:12:37', null, null, '2023-03-24 12:08:42', 0, 4);
select record_version from base_info where base_code <= 3;
commit;