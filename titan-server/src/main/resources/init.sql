DROP DATABASE IF EXISTS titan;
CREATE DATABASE titan CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;
USE titan;

CREATE TABLE sys_option
(
  id           INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  option_key   VARCHAR(100)    NOT NULL UNIQUE,
  option_value VARCHAR(1023)   NOT NULL,
  created      TIMESTAMP       NOT NULL DEFAULT current_timestamp,
  modified     TIMESTAMP       NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8MB4;

CREATE TABLE user
(
  id           INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  username     VARCHAR(45)     NOT NULL UNIQUE,
  password_md5 VARCHAR(45)     NOT NULL,
  email        VARCHAR(45),
  screen_name  VARCHAR(45),
  created      TIMESTAMP       NOT NULL DEFAULT current_timestamp,
  logged       TIMESTAMP       NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8MB4;

create table article
(
  id            int auto_increment
    primary key,
  title         varchar(255)         not null comment '内容标题',
  content       mediumtext           null comment '内容',
  hits          int        default 0 not null comment '点击量',
  tags          varchar(255)         null comment '标签列表',
  category      varchar(255)         null comment '文章分类',
  status        smallint             null comment '内容状态',
  type          varchar(32)          null comment '内容类别',
  allow_comment tinyint(1) default 1 not null comment '是否允许评论',
  comment_count int        default 0 not null comment '评论数量',
  priority      int        default 0 null comment '文章优先级',
  create_time   timestamp            not null comment '创建时间',
  update_time   TIMESTAMP       NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp comment '更新时间',
  creator       int                  null comment '创建人',
  modifier      int                  null comment '修改人',
  deleted       int        default 0 null comment '逻辑删除标识(0.未删除,1.已删除)'
)
  charset = UTF8MB4;

CREATE TABLE comment
(
  id         INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  article_id INT             NOT NULL,
  p_id       INT,
  content    TEXT            NOT NULL,
  name       VARCHAR(255),
  email      VARCHAR(255),
  website    VARCHAR(255),
  agree      INT             NOT NULL DEFAULT 0,
  disagree   INT             NOT NULL DEFAULT 0,
  ip         VARCHAR(255),
  agent      VARCHAR(255),
  status     INT                      DEFAULT 0 NOT NULL,
  created    TIMESTAMP       NOT NULL DEFAULT current_timestamp
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8MB4;

CREATE TABLE meta
(
  id   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(255)    NOT NULL,
  type VARCHAR(45)     NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8MB4;

CREATE TABLE middle
(
  id   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  a_id INT             NOT NULL,
  m_id INT             NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8MB4;

CREATE TABLE log
(
  id      INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  action  VARCHAR(255),
  data    TEXT,
  message VARCHAR(255),
  type    VARCHAR(255),
  ip      VARCHAR(255),
  user_id INT,
  created TIMESTAMP       NOT NULL DEFAULT current_timestamp
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8MB4;

create table snippet_file
(
  id         int auto_increment
    primary key,
  title      varchar(255)                        not null,
  content    text                                null,
  language   varchar(20)                         null,
  tabs       int                                 null,
  snippet_id int                                 null,
  created_at timestamp default CURRENT_TIMESTAMP not null,
  updated_at timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
);

create index index_snippet_files_on_snippet_id
  on snippet_file (snippet_id);


CREATE TABLE media
(
  id        INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  created   TIMESTAMP       NOT NULL DEFAULT current_timestamp,
  modified  TIMESTAMP       NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
  name      VARCHAR(255)    NOT NULL,
  url       VARCHAR(1023)   NOT NULL,
  thumb_url VARCHAR(1023),
  suffix    VARCHAR(255)    NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8MB4;

CREATE TABLE `auth_group`
(
  `group_id`     int(11)      NOT NULL AUTO_INCREMENT,
  `group_name`   varchar(255) NOT NULL DEFAULT '' COMMENT '项目名称',
  `group_url`    varchar(255) NOT NULL DEFAULT '',
  `project_type` varchar(16)  NOT NULL DEFAULT '' COMMENT '系统类型',
  `order`        int(11)               DEFAULT NULL,
  `is_display`   int(11)               DEFAULT NULL COMMENT '显示状态（0不显示，1显示）',
  `style`        varchar(255)          DEFAULT NULL,
  deleted        INT(1)                DEFAULT 0 COMMENT '逻辑删除标识(0.未删除,1.已删除)',
  `creator`      int(11)               DEFAULT NULL,
  `create_time`  timestamp    NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier`     int(11)               DEFAULT NULL,
  `update_time`  timestamp    NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '最近修改时间',
  PRIMARY KEY (`group_id`),
  KEY `IDX_PROJECT_TYPE` (`project_type`)
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8MB4;

CREATE TABLE `auth_classes`
(
  `classes_id`   int(11)      NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `classes_name` varchar(255) NOT NULL DEFAULT '' COMMENT '分类名',
  `classes_url`  varchar(255) NOT NULL,
  `group_id`     int(11)      NOT NULL COMMENT '所属项目',
  `order`        int(11)               DEFAULT NULL,
  `is_display`   int(11)               DEFAULT NULL COMMENT '显示状态（0不显示，1显示）',
  `style`        varchar(255)          DEFAULT NULL,
  deleted        INT(1)                DEFAULT 0 COMMENT '逻辑删除标识(0.未删除,1.已删除)',
  `creator`      int(11)               DEFAULT NULL,
  `create_time`  timestamp    NULL     DEFAULT CURRENT_TIMESTAMP,
  `modifier`     int(11)               DEFAULT NULL,
  `update_time`  timestamp    NULL     DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`classes_id`),
  KEY `IDX_GROUP_ID` (`group_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8MB4;

CREATE TABLE `auth_item`
(
  `item_id`     int(11)      NOT NULL AUTO_INCREMENT COMMENT '权限项ID',
  `item_name`   varchar(255) NOT NULL COMMENT '权限项名称',
  `item_code`   varchar(255) NOT NULL,
  `classes_id`  int(11)      NOT NULL,
  `order`       int(11)           DEFAULT NULL,
  `style`       varchar(255)      DEFAULT NULL,
  `auto_flag`   tinyint(4)        DEFAULT NULL,
  `outer_url`   varchar(1000)     DEFAULT NULL,
  deleted       INT(1)            DEFAULT 0 COMMENT '逻辑删除标识(0.未删除,1.已删除)',
  `creator`     int(11)           DEFAULT NULL,
  `create_time` timestamp    NULL DEFAULT CURRENT_TIMESTAMP,
  `modifier`    int(11)           DEFAULT NULL,
  `update_time` timestamp    NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`item_id`),
  KEY `IDX_ITEM_CODE` (`item_code`)
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8MB4;

create table dim_project
(
  id         bigint auto_increment
    primary key,
  type       varchar(16)  not null comment '产品类型',
  type_name  varchar(255) null comment '产品名',
  is_display tinyint(1)   null comment '是否在顶部显示',
  style      text         null,
  domain     varchar(255) null comment '系统域名'
)
  charset = UTF8MB4;
create index IDX_TYPE
  on dim_project (type);

create table auth_api
(
  api_id       int auto_increment
    primary key,
  api_type     varchar(255) default ''                null comment 'API类型',
  api_path     varchar(255) default ''                not null,
  project_type varchar(64)  default ''                not null comment '类目权限类型',
  deleted      INT(1)       DEFAULT 0 COMMENT '逻辑删除标识(0.未删除,1.已删除)',
  creator      int                                    null,
  create_time  timestamp    default CURRENT_TIMESTAMP null,
  modifier     int                                    null,
  update_time  timestamp    default CURRENT_TIMESTAMP null
)
  charset = UTF8MB4;
create index IDX_PROJECT_TYPE
  on auth_api (project_type);


create table auth_rel_item_api
(
  id          int auto_increment
    primary key,
  item_id     int                                 not null comment '操作项id',
  api_id      int(4)                              not null comment 'api id',
  deleted     INT(1)    DEFAULT 0 COMMENT '逻辑删除标识(0.未删除,1.已删除)',
  creator     int                                 null comment '创建人',
  create_time timestamp default CURRENT_TIMESTAMP null comment '创建时间',
  modifier    int                                 null comment '修改人',
  update_time timestamp default CURRENT_TIMESTAMP null comment '修改时间'
)
  charset = UTF8MB4;
create index IDX_ITEM_API
  on auth_rel_item_api (item_id, api_id);

create table auth_rel_role_api
(
  id          bigint(11) auto_increment
    primary key,
  role_id     int(4)                              not null comment '角色id',
  api_id      int(4)                              not null comment '权限项id',
  deleted     INT(1)    DEFAULT 0 COMMENT '逻辑删除标识(0.未删除,1.已删除)',
  creator     int                                 null comment '创建人',
  create_time timestamp default CURRENT_TIMESTAMP null comment '创建时间',
  modifier    int                                 null comment '修改人',
  update_time timestamp default CURRENT_TIMESTAMP null comment '修改时间'
)
  charset = UTF8MB4;
create index IDX_ROLE_API
  on auth_rel_role_api (role_id, api_id);

create table auth_role
(
  role_id      int auto_increment comment '角色ID'
    primary key,
  role_name    varchar(255) default ''                not null comment '角色名',
  user_type    int(4)                                 not null comment '用户类型',
  role_type    int(4)                                 not null comment '角色类型 1:管理员 2:用户',
  project_type varchar(255)                           null comment '系统类型',
  description  varchar(255)                           null comment '描述',
  deleted      INT(1)       DEFAULT 0 COMMENT '逻辑删除标识(0.未删除,1.已删除)',
  creator      int                                    null,
  create_time  timestamp    default CURRENT_TIMESTAMP null,
  modifier     int                                    null,
  update_time  timestamp    default CURRENT_TIMESTAMP null
)
  charset = UTF8MB4;

create table auth_rel_role_user
(
  id          int auto_increment
    primary key,
  user_id     int                                 not null comment '用户id',
  role_id     int(4)                              not null comment '角色id',
  deleted     INT(1)    DEFAULT 0 COMMENT '逻辑删除标识(0.未删除,1.已删除)',
  creator     int                                 null comment '创建人',
  create_time timestamp default CURRENT_TIMESTAMP null comment '创建时间',
  modifier    int                                 null comment '修改人',
  update_time timestamp default CURRENT_TIMESTAMP null comment '修改时间'
)
  charset = utf8mb4;

create index IDX_USER_ROLE
  on auth_rel_role_user (user_id, role_id);

create table auth_content
(
  id            bigint(11) auto_increment
    primary key,
  project_type  varchar(255) default ''                not null,
  content_type  varchar(255) default ''                not null,
  content_name  varchar(255) default ''                not null,
  content_value varchar(255)                           null,
  deleted       INT(1)       DEFAULT 0 COMMENT '逻辑删除标识(0.未删除,1.已删除)',
  creator       int                                    null,
  create_time   timestamp    default CURRENT_TIMESTAMP null,
  modifier      int                                    null,
  update_time   timestamp    default CURRENT_TIMESTAMP null
)
  charset = UTF8MB4;

create index IDX_CONTENT_TYPE
  on auth_content (content_type);

create index IDX_PROJECT_TYPE
  on auth_content (project_type);


create table auth_rel_role_content
(
  id          bigint(11) auto_increment
    primary key,
  role_id     int(4)                              not null comment '角色id',
  content_id  int(4)                              not null comment '权限项id',
  deleted     INT(1)    DEFAULT 0 COMMENT '逻辑删除标识(0.未删除,1.已删除)',
  creator     int                                 null comment '创建人',
  create_time timestamp default CURRENT_TIMESTAMP null comment '创建时间',
  modifier    int                                 null comment '修改人',
  update_time timestamp default CURRENT_TIMESTAMP null comment '修改时间'
)
  charset = UTF8MB4;
create index IDX_ROLE_CONTENT
  on auth_rel_role_content (role_id, content_id);

create table auth_rel_role_item
(
  id          bigint(11) auto_increment
    primary key,
  role_id     int(4)                              not null comment '角色id',
  item_id     int(4)                              not null comment '权限项id',
  deleted     INT(1)    DEFAULT 0 COMMENT '逻辑删除标识(0.未删除,1.已删除)',
  creator     int                                 null comment '创建人',
  create_time timestamp default CURRENT_TIMESTAMP null comment '创建时间',
  modifier    int                                 null comment '修改人',
  update_time timestamp default CURRENT_TIMESTAMP null comment '修改时间'
)
  charset = UTF8MB4;
create index IDX_ROLE_ITEM
  on auth_rel_role_item (role_id, item_id);

create table task
(
  id          bigint auto_increment primary key,
  concurrent  tinyint      null comment '是否允许并发',
  cron        varchar(50) comment '定时规则',
  data        text         null comment '执行参数',
  exec_at     datetime     null comment '执行时间',
  exec_result text         null comment '执行结果',
  job_class   varchar(255) comment '执行类',
  job_group   varchar(50)  null comment '任务组名',
  name        varchar(50) comment '任务名',
  note        varchar(255) null comment '任务说明',
  status      int          null comment '状态（0无效1有效）',
  deleted     INT(1)    DEFAULT 0 COMMENT '逻辑删除标识(0.未删除,1.已删除)',
  creator     int comment '创建人',
  create_time timestamp default CURRENT_TIMESTAMP comment '创建时间/注册时间',
  modifier    int comment '最后更新人',
  update_time timestamp default CURRENT_TIMESTAMP comment '最后更新时间'
)
  comment '定时任务';


create table task_log
(
  id            bigint auto_increment
    primary key,
  exec_at       datetime     null comment '执行时间',
  exec_success  int          null comment '执行结果（成功:1、失败:0)',
  id_task       bigint       null,
  job_exception varchar(500) null comment '抛出异常',
  name          varchar(50)  null comment '任务名'
)
  comment '定时任务日志';



-- 参数配置表
drop table if exists sys_config;
create table sys_config (
  id         int(5)          not null auto_increment    comment '参数主键',
  config_name       varchar(100)    default ''                 comment '参数名称',
  config_key        varchar(100)    default ''                 comment '参数键名',
  config_value      varchar(500)    default ''                 comment '参数键值',
  remark            varchar(500)    default ''               comment '备注',
  config_type       int(3)         default 0                comment '配置类型 0.系统',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       timestamp default CURRENT_TIMESTAMP        comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       timestamp default CURRENT_TIMESTAMP        comment '更新时间',
    deleted       INT(1)            DEFAULT 0 COMMENT '逻辑删除标识(0.未删除,1.已删除)',
  primary key (id)
) comment = '参数配置表';

-- 设置参数配置
insert into sys_config values(1, 'trello开发者应用Key', 'trello.dev.api.applicationKey',     'key', 'trello开发者属性 请自己设置'  ,   0, 'admin', '2020-04-20 00:00:01', 'admin', '2020-04-20 00:00:01', 0);
insert into sys_config values(2, 'trello开发者API Token',     'trello.dev.api.accessToken',  'token', 'trello开发者属性 请自己设置',       0, 'admin', '2020-04-20 00:00:01', 'admin', '2020-04-20 00:00:01',0 );


