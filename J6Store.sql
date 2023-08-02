CREATE DATABASE J6
GO

USE J6
GO

create table Categories
(
	[Id] nvarchar(40) NOT NULL primary key,
	[Name] nvarchar(50)
)

create table Accounts
(
	[Username] nvarchar(40) NOT NULL primary key,
	[Password] nvarchar(40),
	[Fullname] nvarchar(50),
	[Email] nvarchar(50),
	[Photo] nvarchar(MAX),
	[Activated] bit,
	--[Admin] int
)

create table Products
(
	[Id] int NOT NULL primary key,
	[Name] nvarchar(50),
	[Image] nvarchar(MAX),
	Price  decimal(20,0) null,
	CreateDate date,
	Available bit,
	CategoryId nvarchar(40) NULL,
	FOREIGN KEY (CategoryId) REFERENCES Categories(Id)
)

create table Orders
(
	[Id] bigint NOT NULL primary key,
	[AccountId] nvarchar(40) NUll,
	[CreateDate] date,
	[Address] nvarchar(100),
	[Status] int,
	FOREIGN KEY (AccountId) REFERENCES Accounts(Username)
)

create table OrderDetails
(
	[Id] bigint NOT NULL primary key,
	[OrderId] bigint null,
	[ProductId] int null,
	[Price] decimal(20,0),
	[Quantity] int,
	FOREIGN KEY (OrderId) REFERENCES Orders(Id),
	FOREIGN KEY (ProductId) REFERENCES Products(Id)
)
--drop table Categories
--drop table Products
--drop table OrderDetails
--drop table Orders
--drop table Accounts