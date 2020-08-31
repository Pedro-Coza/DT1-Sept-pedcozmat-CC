
    alter table `accounting_record` 
       drop 
       foreign key `FK41jm4vk7runvmg5tderffrele`;

    alter table `accounting_record` 
       drop 
       foreign key `FKbkhrf7xq9ukr8ehatbksqaf2j`;

    alter table `activity` 
       drop 
       foreign key `FKqwn09ivmw82wd4p7v19hjb5s`;

    alter table `administrator` 
       drop 
       foreign key FK_2a5vcjo3stlfcwadosjfq49l1;

    alter table `anonymous` 
       drop 
       foreign key FK_6lnbc6fo3om54vugoh8icg78m;

    alter table `application` 
       drop 
       foreign key `FK3s3kuyatxrnvoky1v7inyxfr6`;

    alter table `application` 
       drop 
       foreign key `FKl4fp0cd8c008ma79n6w58xhk9`;

    alter table `authenticated` 
       drop 
       foreign key FK_h52w0f3wjoi68b63wv9vwon57;

    alter table `banner` 
       drop 
       foreign key `FKdocr1jjfgwx9ef5jbf675l360`;

    alter table `bookkeeper` 
       drop 
       foreign key FK_krvjp9eaqyapewl2igugbo9o8;

    alter table `consumer` 
       drop 
       foreign key FK_6cyha9f1wpj0dpbxrrjddrqed;

    alter table `credit_card` 
       drop 
       foreign key `FKa4pbn9v8sv66p46fsrke8ow89`;

    alter table `credit_card` 
       drop 
       foreign key `FK31e9eqi896koc93q7yjs5yoox`;

    alter table `enterpreneur` 
       drop 
       foreign key FK_qc6rw0njc9v8xc1netbhmle7o;

    alter table `forum` 
       drop 
       foreign key `FKki6wqsuqf8jnnp13hx0hhuui5`;

    alter table `forum` 
       drop 
       foreign key `FK99d9055vicqa6yxwe6dchh1qy`;

    alter table `forum_authenticated` 
       drop 
       foreign key `FKd1ebx6x0cql1bxphvu15qxh2x`;

    alter table `forum_authenticated` 
       drop 
       foreign key `FKeqgpt52y7qrpoc604i2tgrypw`;

    alter table `investment_round` 
       drop 
       foreign key `FK7pv7ffqu6bxc01rlgcoyfeu4r`;

    alter table `investor` 
       drop 
       foreign key FK_dcek5rr514s3rww0yy57vvnpq;

    alter table `message` 
       drop 
       foreign key `FKfwwpivgx5j4vw4594dgrw884q`;

    alter table `patron` 
       drop 
       foreign key FK_8xx5nujhuio3advxc2freyu65;

    alter table `provider` 
       drop 
       foreign key FK_b1gwnjqm6ggy9yuiqm0o4rlmd;

    alter table `spamword` 
       drop 
       foreign key `FKrk7poykhk0ukf2dm6oqv3rejm`;

    alter table `work_programme` 
       drop 
       foreign key `FKfn830kr4dg472c674839scqgm`;

    drop table if exists `accounting_record`;

    drop table if exists `activity`;

    drop table if exists `administrator`;

    drop table if exists `anonymous`;

    drop table if exists `application`;

    drop table if exists `authenticated`;

    drop table if exists `banner`;

    drop table if exists `bookkeeper`;

    drop table if exists `bulletin`;

    drop table if exists `challenge`;

    drop table if exists `consumer`;

    drop table if exists `credit_card`;

    drop table if exists `enterpreneur`;

    drop table if exists `forum`;

    drop table if exists `forum_authenticated`;

    drop table if exists `inquiry`;

    drop table if exists `investment_round`;

    drop table if exists `investor`;

    drop table if exists `message`;

    drop table if exists `notice`;

    drop table if exists `overture`;

    drop table if exists `patron`;

    drop table if exists `provider`;

    drop table if exists `spamlist`;

    drop table if exists `spamword`;

    drop table if exists `technology_record`;

    drop table if exists `tool_record`;

    drop table if exists `user_account`;

    drop table if exists `work_programme`;

    drop table if exists `hibernate_sequence`;
