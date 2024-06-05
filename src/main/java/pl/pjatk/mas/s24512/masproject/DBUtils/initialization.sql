-- Creating Employee table
CREATE TABLE Employee (
    id NVARCHAR(50) PRIMARY KEY,
    firstName NVARCHAR(50) NOT NULL,
    lastName NVARCHAR(50) NOT NULL,
    login NVARCHAR(50) NOT NULL UNIQUE,
    password NVARCHAR(256) NOT NULL,
    birthDate DATE NOT NULL,
    employmentDate DATE NOT NULL,
    salary DECIMAL(18, 2) NOT NULL,
    managerId NVARCHAR(50)
);

-- Data insertion to Employee
INSERT INTO Employee (id, firstName, lastName, login, password, birthDate, employmentDate, salary)
VALUES
--     planners
('beb99b51-cf72-47a2-aff0-24dc4c17cfe8', 'John', 'Doe', 'johdoe0', 'password123', '1980-05-15', '2010-06-01', 60000.00, 'bc6b671a-1978-4ba1-91ff-0e7c98eaff8d'),
('c0edda08-6be2-46a2-b49d-9e891dd0327a', 'Jane', 'Smith', 'jansmi0', 'password456', '1985-07-20', '2012-09-15', 65000.00, 'bc6b671a-1978-4ba1-91ff-0e7c98eaff8d'),
('46e34848-f01a-4b54-8aa6-5d64a9431982', 'Alice', 'Johnson', 'alijoh0', 'password789', '1990-11-30', '2015-03-25', 70000.00, 'bc6b671a-1978-4ba1-91ff-0e7c98eaff8d'),
--     planner manager
    ('bc6b671a-1978-4ba1-91ff-0e7c98eaff8d', 'Samantha', 'Johnson', 'samjoh0', 'password321', '1983-06-08', '2009-10-30', 58000.00, NULL),
--     traffics
    ('9ff2c4d0-17bc-4f10-9f3b-9f65d547f49b', 'Michael', 'Taylor', 'mictay0', 'password987', '1986-04-03', '2017-05-20', 72000.00, 'e24b34c1-80f4-423f-b042-e3a2c19f4d81'),
    ('83c3a964-b94b-4d67-96e6-d01239946f7d', 'Jane', 'Smith', 'jansmi0', 'password456', '1985-07-20', '2012-09-15', 65000.00, 'e24b34c1-80f4-423f-b042-e3a2c19f4d81'),
    ('7fee0d2e-751b-449e-b6f8-491a2210dd1d', 'Alice', 'Johnson', 'alijoh0', 'password789', '1990-11-30', '2015-03-25', 70000.00, 'e5bbf396-6e7b-4e58-9f69-b5d6a6dd5b6b'),
--     traffic manager
    ('e24b34c1-80f4-423f-b042-e3a2c19f4d81', 'Bob', 'Brown', 'bobbro0', 'password101', '1992-03-10', '2018-08-10', 55000.00, NULL),
--     traffic AIO
    ('e5bbf396-6e7b-4e58-9f69-b5d6a6dd5b6b', 'Sarah', 'Anderson', 'sarand0', 'password246', '1994-08-12', '2016-11-25', 62000.00, NULL),
--     Designer
    ('7cb68ec3-d76a-4314-8e88-4a3c4b4eab64', 'Christopher', 'Wilson', 'chrwil0', 'password753', '1989-02-28', '2013-07-15', 68000.00, NULL),
--     Campaign accountant
    ('b3a1f73b-c90a-4dbd-b729-4d1f166982fc', 'Jessica', 'Martinez', 'jesmar0', 'password159', '1997-05-20', '2019-09-08', 58000.00, NULL),
--     Company accountant
    ('9327e2d3-8920-4841-95c2-fc9200b748e8', 'Matthew', 'Rodriguez', 'matrod0', 'password852', '1990-11-15', '2012-04-30', 72000.00, NULL),
--     Company/Campaign accountant
('28a91aa2-8100-4c18-91e2-7e5d6761e013', 'Amanda', 'Harris', 'amahar0', 'password753', '1993-10-05', '2015-02-20', 65000.00, NULL);



-- Creating Plan Table
CREATE TABLE Plan (
    id NVARCHAR(50) PRIMARY KEY,
    estimatedRate INT NOT NULL,
    target NVARCHAR(100) NOT NULL,
    communicationChannel NVCHAR(50) NOT NULL
);

-- Data insertion to Plan
INSERT INTO Plan (id, estimatedRate, target, communicationChannel)
VALUES
    ('4524ae45-e569-433a-8ab6-610b828d9e0b', 100, 'Rolnicy', 'EMAIL'),
    ('5c34a3c0-37ae-413e-9b16-98ffeec262ee', 150, 'Gracze', 'SMS'),
    ('26101caa-01ab-4ed3-b9a5-6033e8ba0769', 200, 'Biznesmeni', 'WEBSITES'),
    ('9e2748e0-bc60-4eb0-8a3e-32b0df942aea', 120, 'Studenci', 'APPLICATIONS');

-- Creating CommunicationPlanner Table
CREATE TABLE CommunicationPlanner (
    id NVARCHAR(50) PRIMARY KEY
);

-- Data insertion to CommunicationPlanner
INSERT INTO CommunicationPlanner (id)
VALUES
    ('beb99b51-cf72-47a2-aff0-24dc4c17cfe8'),
    ('c0edda08-6be2-46a2-b49d-9e891dd0327a'),
    ('46e34848-f01a-4b54-8aa6-5d64a9431982');

CREATE TABLE PlannerManager (
    id NVARCHAR(50) PRIMARY KEY
);

-- Data insertion to CommunicationPlanner
INSERT INTO PlannerManager (id)
VALUES
    ('bc6b671a-1978-4ba1-91ff-0e7c98eaff8d');

-- Creating Traffic Table
CREATE TABLE Traffic (
    id NVARCHAR(50) PRIMARY KEY
);

-- Data insertion to Traffic
INSERT INTO Traffic (id)
VALUES
    ('9ff2c4d0-17bc-4f10-9f3b-9f65d547f49b'),
    ('83c3a964-b94b-4d67-96e6-d01239946f7d'),
    ('7fee0d2e-751b-449e-b6f8-491a2210dd1d');

-- Creating TrafficManager Table
CREATE TABLE TrafficManager (
    id NVARCHAR(50) PRIMARY KEY
);

-- Data insertion to TrafficManager
INSERT INTO TrafficManager (id)
VALUES
    ('e24b34c1-80f4-423f-b042-e3a2c19f4d81');

-- Creating TrafficAIO Table
CREATE TABLE TrafficAIO (
    id NVARCHAR(50) PRIMARY KEY
);

-- Data insertion to TrafficAIO
INSERT INTO TrafficAIO (id)
VALUES
    ('e5bbf396-6e7b-4e58-9f69-b5d6a6dd5b6b');

-- Creating Designer Table
CREATE TABLE Designer (
    id NVARCHAR(50) PRIMARY KEY
);

-- Data insertion to Designer
INSERT INTO Designer (id)
VALUES
    ('7cb68ec3-d76a-4314-8e88-4a3c4b4eab64');

-- Creating CampaignAccountant Table
CREATE TABLE CampaignAccountant (
    id NVARCHAR(50) PRIMARY KEY
);

-- Data insertion to CampaignAccountant
INSERT INTO CampaignAccountant (id)
VALUES
    ('b3a1f73b-c90a-4dbd-b729-4d1f166982fc');

-- Creating CompanyAccountant Table
CREATE TABLE CompanyAccountant (
    id NVARCHAR(50) PRIMARY KEY
);

-- Data insertion to CompanyAccountant
INSERT INTO CompanyAccountant (id)
VALUES
    ('b3a1f73b-c90a-4dbd-b729-4d1f166982fc');

-- Creating AccountantAIO Table
CREATE TABLE AccountantAIO (
    id NVARCHAR(50) PRIMARY KEY
);

-- Data insertion to AccountantAIO
INSERT INTO AccountantAIO (id)
VALUES
    ('28a91aa2-8100-4c18-91e2-7e5d6761e013');

-- Creating Client Table
CREATE TABLE Client (
    id NVARCHAR(50) PRIMARY KEY,
    firstName NVARCHAR(50) NOT NULL,
    lastName NVARCHAR(50) NOT NULL,
    emailAddress NVARCHAR(100) NOT NULL,
    phoneNumber NVARCHAR(20) NOT NULL,
    companyId NVARCHAR(50) NOT NULL
);

-- Data insertion to Client
INSERT INTO Client (id, firstName, lastName, emailAddress, phoneNumber, companyId)
VALUES
    ('c1f8254d-37f6-4ff5-bb55-03dbf95e42a1', 'John', 'Doe', 'john.doe@example.com', '+123456789', '4ff7d4d1-8a2e-4f0a-aa2a-f67f83e7de02'),
    ('b1641f49-147e-4626-b79e-2b2c6c1960b7', 'Jane', 'Smith', 'jane.smith@example.com', '+987654321', '4ff7d4d1-8a2e-4f0a-aa2a-f67f83e7de02'),
    ('e7381df8-ffbb-4380-86b5-dcd7a7f0e382', 'Alice', 'Johnson', 'alice.johnson@example.com', '+1122334455', 'f5ab6b0a-5143-437d-ba6f-6bb0f69e043e'),
    ('f4cb1a32-88b2-41fb-b90e-869d28fe409c', 'Bob', 'Brown', 'bob.brown@example.com', '+9988776655', 'f5ab6b0a-5143-437d-ba6f-6bb0f69e043e');

-- Creating Company Table
CREATE TABLE Company (
    id NVARCHAR(50) PRIMARY KEY,
    name NVARCHAR(100) NOT NULL,
    address NVARCHAR(255) NOT NULL,
    accountNumber NVARCHAR(20) NOT NULL,
    isRegular VARCHAR(50) NOT NULL
);

-- Data insertion to Company
INSERT INTO Company (id, name, address, accountNumber, isRegular)
VALUES
    ('4ff7d4d1-8a2e-4f0a-aa2a-f67f83e7de02', 'ABC Company', '123 Main Street, City, Country', '1234567890', 'true'),
    ('f5ab6b0a-5143-437d-ba6f-6bb0f69e043e', 'XYZ Corporation', '456 Elm Street, OtherCity, MyCountry', '0987654321', 'false');

-- Creating EducationLevel table
CREATE TABLE EducationLevel (
    level NVARCHAR(50) PRIMARY KEY,
    factor DECIMAL(18, 2) NOT NULL
);

-- Data insertion to EducationLevel
INSERT INTO EducationLevel (level, factor)
VALUES
    ('technician', 1.2),
    ('degree', 1.5),
    ('master degree', 1.8);

-- Creating Price table
CREATE TABLE Price (
    type NVARCHAR(50) PRIMARY KEY,
    value DECIMAL(18, 2) NOT NULL
);

-- Data insertion to Price
INSERT INTO Price (type, value)
VALUES
    ('CPC', 0.10),
    ('CPU', 0.30),
    ('CPM', 0.35),
    ('NewClientStandard', 0.50);
