-- AUTHORIZATION --

-- add grant authorizations for group camunda-admin:
INSERT INTO
  ACT_RU_AUTHORIZATION (ID_, TYPE_, GROUP_ID_, RESOURCE_TYPE_, RESOURCE_ID_, PERMS_, REV_)
VALUES
  ('camunda-admin-grant-drd', 1, 'camunda-admin', 14, '*', 2147483647, 1);

-- decision requirement definition --

ALTER TABLE ACT_RE_DECISION_DEF
  ADD DEC_REQ_ID_ nvarchar(64);

create table ACT_RE_DECISION_REQ_DEF (
    ID_ nvarchar(64) NOT NULL,
    REV_ int,
    CATEGORY_ nvarchar(255),
    NAME_ nvarchar(255),
    KEY_ nvarchar(255) NOT NULL,
    VERSION_ int NOT NULL,
    DEPLOYMENT_ID_ nvarchar(64),
    RESOURCE_NAME_ nvarchar(4000),
    DGRM_RESOURCE_NAME_ nvarchar(4000),
    TENANT_ID_ nvarchar(64),
    primary key (ID_)
);

alter table ACT_RE_DECISION_DEF
    add constraint ACT_FK_DEC_REQ
    foreign key (DEC_REQ_ID_)
    references ACT_RE_DECISION_REQ_DEF(ID_);

create index ACT_IDX_DEC_DEF_REQ_ID on ACT_RE_DECISION_DEF(DEC_REQ_ID_);
create index ACT_IDX_DEC_REQ_DEF_TENANT_ID on ACT_RE_DECISION_REQ_DEF(TENANT_ID_);

