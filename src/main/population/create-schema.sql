
    create table `accounting_record` (
       `id` integer not null,
        `version` integer not null,
        `body` varchar(255),
        `creation_moment` datetime(6),
        `status` varchar(255),
        `title` varchar(255),
        `bookkeeper_id` integer not null,
        `inv_round_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `activity` (
       `id` integer not null,
        `version` integer not null,
        `budget_amount` double precision,
        `budget_currency` varchar(255),
        `end_date` datetime(6),
        `start_date` datetime(6),
        `title` varchar(255),
        `work_prog_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `administrator` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `anonymous` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `application` (
       `id` integer not null,
        `version` integer not null,
        `creation_date` datetime(6),
        `inv_offer_amount` double precision,
        `inv_offer_currency` varchar(255),
        `justification` varchar(255),
        `statement` varchar(255),
        `status` varchar(255),
        `ticker` varchar(255),
        `inv_round_id` integer not null,
        `investor_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `authenticated` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `banner` (
       `id` integer not null,
        `version` integer not null,
        `picture` varchar(255),
        `slogan` varchar(255),
        `target_url` varchar(255),
        `patron_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `bookkeeper` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `firm_name` varchar(255),
        `statement` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `bulletin` (
       `id` integer not null,
        `version` integer not null,
        `author` varchar(255),
        `moment` datetime(6),
        `text` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `challenge` (
       `id` integer not null,
        `version` integer not null,
        `average` varchar(255),
        `average_reward_amount` double precision,
        `average_reward_currency` varchar(255),
        `deadline` datetime(6),
        `description` varchar(255),
        `expert` varchar(255),
        `expert_reward_amount` double precision,
        `expert_reward_currency` varchar(255),
        `rookie` varchar(255),
        `rookie_reward_amount` double precision,
        `rookie_reward_currency` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `consumer` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `credit_card` (
       `id` integer not null,
        `version` integer not null,
        `cvv` varchar(255),
        `expiration_date` varchar(255),
        `holder_name` varchar(255),
        `number` varchar(255),
        `banner_id` integer,
        `patron_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `enterpreneur` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `activity_sector` varchar(255),
        `qualif_record` varchar(255),
        `skill_record` varchar(255),
        `startup_name` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `forum` (
       `id` integer not null,
        `version` integer not null,
        `creation_date` datetime(6),
        `title` varchar(255),
        `administrator_id` integer,
        `inv_round_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `forum_authenticated` (
       `id` integer not null,
        `version` integer not null,
        `forum_id` integer,
        `user_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `inquiry` (
       `id` integer not null,
        `version` integer not null,
        `creation_date` datetime(6),
        `deadline` datetime(6),
        `description` varchar(255),
        `email` varchar(255),
        `mmax_amount` double precision,
        `mmax_currency` varchar(255),
        `mmin_amount` double precision,
        `mmin_currency` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `investment_round` (
       `id` integer not null,
        `version` integer not null,
        `active` varchar(255),
        `creation_date` datetime(6),
        `info` varchar(255),
        `kind_round` varchar(255),
        `money_amount` double precision,
        `money_currency` varchar(255),
        `ticker` varchar(255),
        `title` varchar(255),
        `enterpreneur_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `investor` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `activity_sector` varchar(255),
        `firm_name` varchar(255),
        `profile` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `message` (
       `id` integer not null,
        `version` integer not null,
        `body` varchar(255),
        `creation_moment` datetime(6),
        `tags` varchar(255),
        `title` varchar(255),
        `forum_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `notice` (
       `id` integer not null,
        `version` integer not null,
        `body` varchar(255),
        `creation_date` datetime(6),
        `deadline` datetime(6),
        `header` varchar(255),
        `related_links` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `overture` (
       `id` integer not null,
        `version` integer not null,
        `creation_date` datetime(6),
        `deadline` datetime(6),
        `description` varchar(255),
        `email` varchar(255),
        `mmax_amount` double precision,
        `mmax_currency` varchar(255),
        `mmin_amount` double precision,
        `mmin_currency` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `patron` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `org_name` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `provider` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `spamlist` (
       `id` integer not null,
        `version` integer not null,
        `idiom` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `spamword` (
       `id` integer not null,
        `version` integer not null,
        `spamword` varchar(255),
        `spamlist_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `technology_record` (
       `id` integer not null,
        `version` integer not null,
        `activity_sector` varchar(255),
        `description` varchar(255),
        `email` varchar(255),
        `investor_name` varchar(255),
        `rating` integer,
        `source` varchar(255),
        `title` varchar(255),
        `website` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `tool_record` (
       `id` integer not null,
        `version` integer not null,
        `activity_sector` varchar(255),
        `description` varchar(255),
        `email` varchar(255),
        `investor_name` varchar(255),
        `rating` integer,
        `source` varchar(255),
        `title` varchar(255),
        `website` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `user_account` (
       `id` integer not null,
        `version` integer not null,
        `enabled` bit not null,
        `identity_email` varchar(255),
        `identity_name` varchar(255),
        `identity_surname` varchar(255),
        `password` varchar(255),
        `username` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `work_programme` (
       `id` integer not null,
        `version` integer not null,
        `inv_round_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `hibernate_sequence` (
       `next_val` bigint
    ) engine=InnoDB;

    insert into `hibernate_sequence` values ( 1 );
create index IDX2insomc4a40jprju8tmgcvmig on `spamword` (`spamword`);
create index IDXr7lyttb4bnfd85oud954xkpx7 on `technology_record` (`activity_sector` asc);
create index IDXqbw8w2s6652rbjawhqvaguci0 on `technology_record` (`rating` asc);
create index IDX7rwm294nfcoq797e0l99lux40 on `tool_record` (`activity_sector` asc);
create index IDXr8s9h3wycn19a9jpeqoqflx4x on `tool_record` (`rating` asc);

    alter table `user_account` 
       add constraint UK_castjbvpeeus0r8lbpehiu0e4 unique (`username`);

    alter table `accounting_record` 
       add constraint `FK41jm4vk7runvmg5tderffrele` 
       foreign key (`bookkeeper_id`) 
       references `bookkeeper` (`id`);

    alter table `accounting_record` 
       add constraint `FKbkhrf7xq9ukr8ehatbksqaf2j` 
       foreign key (`inv_round_id`) 
       references `investment_round` (`id`);

    alter table `activity` 
       add constraint `FKqwn09ivmw82wd4p7v19hjb5s` 
       foreign key (`work_prog_id`) 
       references `work_programme` (`id`);

    alter table `administrator` 
       add constraint FK_2a5vcjo3stlfcwadosjfq49l1 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `anonymous` 
       add constraint FK_6lnbc6fo3om54vugoh8icg78m 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `application` 
       add constraint `FK3s3kuyatxrnvoky1v7inyxfr6` 
       foreign key (`inv_round_id`) 
       references `investment_round` (`id`);

    alter table `application` 
       add constraint `FKl4fp0cd8c008ma79n6w58xhk9` 
       foreign key (`investor_id`) 
       references `investor` (`id`);

    alter table `authenticated` 
       add constraint FK_h52w0f3wjoi68b63wv9vwon57 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `banner` 
       add constraint `FKdocr1jjfgwx9ef5jbf675l360` 
       foreign key (`patron_id`) 
       references `patron` (`id`);

    alter table `bookkeeper` 
       add constraint FK_krvjp9eaqyapewl2igugbo9o8 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `consumer` 
       add constraint FK_6cyha9f1wpj0dpbxrrjddrqed 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `credit_card` 
       add constraint `FKa4pbn9v8sv66p46fsrke8ow89` 
       foreign key (`banner_id`) 
       references `banner` (`id`);

    alter table `credit_card` 
       add constraint `FK31e9eqi896koc93q7yjs5yoox` 
       foreign key (`patron_id`) 
       references `patron` (`id`);

    alter table `enterpreneur` 
       add constraint FK_qc6rw0njc9v8xc1netbhmle7o 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `forum` 
       add constraint `FKki6wqsuqf8jnnp13hx0hhuui5` 
       foreign key (`administrator_id`) 
       references `user_account` (`id`);

    alter table `forum` 
       add constraint `FK99d9055vicqa6yxwe6dchh1qy` 
       foreign key (`inv_round_id`) 
       references `investment_round` (`id`);

    alter table `forum_authenticated` 
       add constraint `FKd1ebx6x0cql1bxphvu15qxh2x` 
       foreign key (`forum_id`) 
       references `forum` (`id`);

    alter table `forum_authenticated` 
       add constraint `FKeqgpt52y7qrpoc604i2tgrypw` 
       foreign key (`user_id`) 
       references `user_account` (`id`);

    alter table `investment_round` 
       add constraint `FK7pv7ffqu6bxc01rlgcoyfeu4r` 
       foreign key (`enterpreneur_id`) 
       references `enterpreneur` (`id`);

    alter table `investor` 
       add constraint FK_dcek5rr514s3rww0yy57vvnpq 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `message` 
       add constraint `FKfwwpivgx5j4vw4594dgrw884q` 
       foreign key (`forum_id`) 
       references `forum` (`id`);

    alter table `patron` 
       add constraint FK_8xx5nujhuio3advxc2freyu65 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `provider` 
       add constraint FK_b1gwnjqm6ggy9yuiqm0o4rlmd 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `spamword` 
       add constraint `FKrk7poykhk0ukf2dm6oqv3rejm` 
       foreign key (`spamlist_id`) 
       references `spamlist` (`id`);

    alter table `work_programme` 
       add constraint `FKfn830kr4dg472c674839scqgm` 
       foreign key (`inv_round_id`) 
       references `investment_round` (`id`);
