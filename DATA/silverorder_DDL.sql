-- CREATE DATABASE silverorder COLLATE Korean_100_CI_AS_SC_UTF8;

USE [silverorder]
GO
/****** Object:  Table [dbo].[t_account]    Script Date: 2024-10-07 오전 9:32:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_account](
	[account_num] [varchar](30) NOT NULL,
	[account_pass] [varchar](200) NOT NULL,
	[payment_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[payment_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[t_card]    Script Date: 2024-10-07 오전 9:32:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_card](
	[card_cvc] [varchar](7) NOT NULL,
	[card_issuer_name] [varchar](255) NULL,
	[card_name] [varchar](255) NULL,
	[card_num] [varchar](255) NOT NULL,
	[discount_rate] [float] NULL,
	[payment_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[payment_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[t_code_group]    Script Date: 2024-10-07 오전 9:32:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_code_group](
	[group_id] [bigint] NOT NULL,
	[group_name] [varchar](50) NOT NULL,
	[insert_date] [datetime2](6) NOT NULL,
	[used_column] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[group_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[t_common_code]    Script Date: 2024-10-07 오전 9:32:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_common_code](
	[code_id] [bigint] NOT NULL,
	[insert_date] [datetime2](6) NOT NULL,
	[code_value] [varchar](50) NULL,
	[group_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[code_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[t_menu]    Script Date: 2024-10-07 오전 9:32:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_menu](
	[menu_id] [bigint] IDENTITY(1,1) NOT NULL,
	[menu_desc] [varchar](1000) NULL,
	[menu_name] [varchar](50) NOT NULL,
	[menu_price] [int] NOT NULL,
	[menu_status] [varchar](255) NOT NULL,
	[recommend] [int] NOT NULL,
	[simple_name] [varchar](50) NOT NULL,
	[thumb] [varchar](100) NULL,
	[menu_category_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[menu_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[t_menu_option_category]    Script Date: 2024-10-07 오전 9:32:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_menu_option_category](
	[menu_option_category_id] [bigint] IDENTITY(1,1) NOT NULL,
	[menu_id] [bigint] NOT NULL,
	[option_category_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[menu_option_category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UNI_MENU_OPTION_CATEGORY] UNIQUE NONCLUSTERED 
(
	[option_category_id] ASC,
	[menu_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[t_option]    Script Date: 2024-10-07 오전 9:32:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_option](
	[option_id] [bigint] IDENTITY(1,1) NOT NULL,
	[option_name] [varchar](50) NOT NULL,
	[option_price] [int] NOT NULL,
	[option_category_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[option_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[t_option_category]    Script Date: 2024-10-07 오전 9:32:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_option_category](
	[option_category_id] [bigint] IDENTITY(1,1) NOT NULL,
	[option_category_title] [varchar](20) NOT NULL,
	[option_type] [varchar](255) NOT NULL,
	[store_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[option_category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[t_order]    Script Date: 2024-10-07 오전 9:32:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_order](
	[order_id] [bigint] IDENTITY(1,1) NOT NULL,
	[order_date] [date] NOT NULL,
	[order_status] [varchar](255) NOT NULL,
	[order_time] [datetime2](6) NOT NULL,
	[pay_price] [bigint] NOT NULL,
	[require] [varchar](200) NULL,
	[trade_num] [bigint] NOT NULL,
	[payment_id] [bigint] NOT NULL,
	[store_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[t_order_menu]    Script Date: 2024-10-07 오전 9:32:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_order_menu](
	[order_menu_id] [bigint] IDENTITY(1,1) NOT NULL,
	[menu_amount] [int] NULL,
	[menu_price] [bigint] NULL,
	[menu_id] [bigint] NOT NULL,
	[order_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[order_menu_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[t_order_option]    Script Date: 2024-10-07 오전 9:32:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_order_option](
	[order_option_id] [bigint] IDENTITY(1,1) NOT NULL,
	[option_id] [bigint] NOT NULL,
	[order_menu_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[order_option_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[t_owner_review]    Script Date: 2024-10-07 오전 9:32:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_owner_review](
	[comment_id] [bigint] IDENTITY(1,1) NOT NULL,
	[content] [varchar](2000) NULL,
	[created_date] [date] NOT NULL,
	[modified_date] [date] NOT NULL,
	[review_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[comment_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UKl7osrcga53bpgxtcvt10fxs52] UNIQUE NONCLUSTERED 
(
	[review_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[t_payment]    Script Date: 2024-10-07 오전 9:32:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_payment](
	[payment_id] [bigint] IDENTITY(1,1) NOT NULL,
	[payment_type] [varchar](255) NOT NULL,
	[user_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[payment_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[t_proc_age_menu_sales]    Script Date: 2024-10-07 오전 9:32:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_proc_age_menu_sales](
	[proc_id] [bigint] IDENTITY(1,1) NOT NULL,
	[insert_date] [date] NOT NULL,
	[proc_date] [date] NOT NULL,
	[proc_menu_amount] [int] NOT NULL,
	[purchase_age] [int] NOT NULL,
	[menu_id] [bigint] NOT NULL,
	[store_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[proc_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UNI_STORE_DATE_AGE_MENU] UNIQUE NONCLUSTERED 
(
	[store_id] ASC,
	[proc_date] ASC,
	[menu_id] ASC,
	[purchase_age] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[t_proc_sales]    Script Date: 2024-10-07 오전 9:32:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_proc_sales](
	[proc_id] [bigint] IDENTITY(1,1) NOT NULL,
	[insert_date] [date] NOT NULL,
	[proc_daily_sales] [bigint] NOT NULL,
	[proc_date] [date] NOT NULL,
	[store_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[proc_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UNI_STORE_DATE] UNIQUE NONCLUSTERED 
(
	[store_id] ASC,
	[proc_date] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[t_review]    Script Date: 2024-10-07 오전 9:32:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_review](
	[review_id] [bigint] IDENTITY(1,1) NOT NULL,
	[content] [varchar](2000) NULL,
	[created_date] [date] NOT NULL,
	[modified_date] [date] NOT NULL,
	[rating] [int] NOT NULL,
	[review_thumb] [varchar](100) NULL,
	[order_id] [bigint] NOT NULL,
	[user_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[review_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UKf6yk00g4yyrrbujfgm3n2ws80] UNIQUE NONCLUSTERED 
(
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[t_store]    Script Date: 2024-10-07 오전 9:32:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_store](
	[store_id] [bigint] NOT NULL,
	[account_num] [varchar](30) NULL,
	[address] [varchar](255) NOT NULL,
	[close_time] [varchar](4) NOT NULL,
	[latitude] [float] NULL,
	[longitude] [float] NULL,
	[open_time] [varchar](4) NOT NULL,
	[store_category] [varchar](50) NOT NULL,
	[store_desc] [varchar](200) NULL,
	[store_name] [varchar](100) NOT NULL,
	[store_rate] [float] NOT NULL,
	[store_status] [varchar](50) NOT NULL,
	[user_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[store_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[t_store_menu_category]    Script Date: 2024-10-07 오전 9:32:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_store_menu_category](
	[menu_category_id] [bigint] IDENTITY(1,1) NOT NULL,
	[menu_category_name] [varchar](20) NOT NULL,
	[store_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[menu_category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[t_user]    Script Date: 2024-10-07 오전 9:32:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_user](
	[user_id] [bigint] IDENTITY(1,1) NOT NULL,
	[user_api_email] [varchar](100) NULL,
	[user_api_key] [varchar](200) NULL,
	[user_birth] [date] NOT NULL,
	[user_email] [varchar](30) NOT NULL,
	[user_join_date] [datetime2](6) NOT NULL,
	[user_pw] [varchar](200) NOT NULL,
	[user_role] [varchar](255) NOT NULL,
	[user_update_date] [datetime2](6) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UKbv4irau025kecgcf0p6qbng4n] UNIQUE NONCLUSTERED 
(
	[user_email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[t_menu] ADD  DEFAULT ((0)) FOR [menu_price]
GO
ALTER TABLE [dbo].[t_menu] ADD  DEFAULT ((0)) FOR [recommend]
GO
ALTER TABLE [dbo].[t_option] ADD  DEFAULT ((0)) FOR [option_price]
GO
ALTER TABLE [dbo].[t_account]  WITH CHECK ADD  CONSTRAINT [FKfk6y2xdnbnsuc012q2xuas93j] FOREIGN KEY([payment_id])
REFERENCES [dbo].[t_payment] ([payment_id])
GO
ALTER TABLE [dbo].[t_account] CHECK CONSTRAINT [FKfk6y2xdnbnsuc012q2xuas93j]
GO
ALTER TABLE [dbo].[t_card]  WITH CHECK ADD  CONSTRAINT [FKk3n4wcfylrjrjbfsco70kkjl6] FOREIGN KEY([payment_id])
REFERENCES [dbo].[t_payment] ([payment_id])
GO
ALTER TABLE [dbo].[t_card] CHECK CONSTRAINT [FKk3n4wcfylrjrjbfsco70kkjl6]
GO
ALTER TABLE [dbo].[t_common_code]  WITH CHECK ADD  CONSTRAINT [FK8ubxadpdg79o2ow4cuid9cj9o] FOREIGN KEY([group_id])
REFERENCES [dbo].[t_code_group] ([group_id])
GO
ALTER TABLE [dbo].[t_common_code] CHECK CONSTRAINT [FK8ubxadpdg79o2ow4cuid9cj9o]
GO
ALTER TABLE [dbo].[t_menu]  WITH CHECK ADD  CONSTRAINT [FKq3fq10gyeotxeljr29pl0td18] FOREIGN KEY([menu_category_id])
REFERENCES [dbo].[t_store_menu_category] ([menu_category_id])
GO
ALTER TABLE [dbo].[t_menu] CHECK CONSTRAINT [FKq3fq10gyeotxeljr29pl0td18]
GO
ALTER TABLE [dbo].[t_menu_option_category]  WITH CHECK ADD  CONSTRAINT [FKjtvv2bxsq4moxqp4ka388nup6] FOREIGN KEY([menu_id])
REFERENCES [dbo].[t_menu] ([menu_id])
GO
ALTER TABLE [dbo].[t_menu_option_category] CHECK CONSTRAINT [FKjtvv2bxsq4moxqp4ka388nup6]
GO
ALTER TABLE [dbo].[t_menu_option_category]  WITH CHECK ADD  CONSTRAINT [FKoui1s2gv3vb8kcegmtn2jsg4f] FOREIGN KEY([option_category_id])
REFERENCES [dbo].[t_option_category] ([option_category_id])
GO
ALTER TABLE [dbo].[t_menu_option_category] CHECK CONSTRAINT [FKoui1s2gv3vb8kcegmtn2jsg4f]
GO
ALTER TABLE [dbo].[t_option]  WITH CHECK ADD  CONSTRAINT [FKl1kyytv4wp0x8adp3wr5pp3h7] FOREIGN KEY([option_category_id])
REFERENCES [dbo].[t_option_category] ([option_category_id])
GO
ALTER TABLE [dbo].[t_option] CHECK CONSTRAINT [FKl1kyytv4wp0x8adp3wr5pp3h7]
GO
ALTER TABLE [dbo].[t_option_category]  WITH CHECK ADD  CONSTRAINT [FKg0g71ht51609rjqtnels7fp1x] FOREIGN KEY([store_id])
REFERENCES [dbo].[t_store] ([store_id])
GO
ALTER TABLE [dbo].[t_option_category] CHECK CONSTRAINT [FKg0g71ht51609rjqtnels7fp1x]
GO
ALTER TABLE [dbo].[t_order]  WITH CHECK ADD  CONSTRAINT [FKpb8odngkdlq0bopbh2t4g3kdb] FOREIGN KEY([store_id])
REFERENCES [dbo].[t_store] ([store_id])
GO
ALTER TABLE [dbo].[t_order] CHECK CONSTRAINT [FKpb8odngkdlq0bopbh2t4g3kdb]
GO
ALTER TABLE [dbo].[t_order]  WITH CHECK ADD  CONSTRAINT [FKrkwhosh33x4bt8gvrm773crfp] FOREIGN KEY([payment_id])
REFERENCES [dbo].[t_payment] ([payment_id])
GO
ALTER TABLE [dbo].[t_order] CHECK CONSTRAINT [FKrkwhosh33x4bt8gvrm773crfp]
GO
ALTER TABLE [dbo].[t_order_menu]  WITH CHECK ADD  CONSTRAINT [FK34ek3gp3ex4bavbhon8ci1gck] FOREIGN KEY([menu_id])
REFERENCES [dbo].[t_menu] ([menu_id])
GO
ALTER TABLE [dbo].[t_order_menu] CHECK CONSTRAINT [FK34ek3gp3ex4bavbhon8ci1gck]
GO
ALTER TABLE [dbo].[t_order_menu]  WITH CHECK ADD  CONSTRAINT [FKglaoakewla5ytl6tw14nu2fqm] FOREIGN KEY([order_id])
REFERENCES [dbo].[t_order] ([order_id])
GO
ALTER TABLE [dbo].[t_order_menu] CHECK CONSTRAINT [FKglaoakewla5ytl6tw14nu2fqm]
GO
ALTER TABLE [dbo].[t_order_option]  WITH CHECK ADD  CONSTRAINT [FKfe7tvpj802wjcf1qh4y65sksc] FOREIGN KEY([option_id])
REFERENCES [dbo].[t_option] ([option_id])
GO
ALTER TABLE [dbo].[t_order_option] CHECK CONSTRAINT [FKfe7tvpj802wjcf1qh4y65sksc]
GO
ALTER TABLE [dbo].[t_order_option]  WITH CHECK ADD  CONSTRAINT [FKmahtv4efgn8rph7jucyux597p] FOREIGN KEY([order_menu_id])
REFERENCES [dbo].[t_order_menu] ([order_menu_id])
GO
ALTER TABLE [dbo].[t_order_option] CHECK CONSTRAINT [FKmahtv4efgn8rph7jucyux597p]
GO
ALTER TABLE [dbo].[t_owner_review]  WITH CHECK ADD  CONSTRAINT [FKilgiekhr6ji28nocouf3wkwyx] FOREIGN KEY([review_id])
REFERENCES [dbo].[t_review] ([review_id])
GO
ALTER TABLE [dbo].[t_owner_review] CHECK CONSTRAINT [FKilgiekhr6ji28nocouf3wkwyx]
GO
ALTER TABLE [dbo].[t_payment]  WITH CHECK ADD  CONSTRAINT [FKo0uk05cd9ie1ivcgh84xg7ngo] FOREIGN KEY([user_id])
REFERENCES [dbo].[t_user] ([user_id])
GO
ALTER TABLE [dbo].[t_payment] CHECK CONSTRAINT [FKo0uk05cd9ie1ivcgh84xg7ngo]
GO
ALTER TABLE [dbo].[t_proc_age_menu_sales]  WITH CHECK ADD  CONSTRAINT [FK8q3xasa3p70vyvxk9rlhw8qrp] FOREIGN KEY([menu_id])
REFERENCES [dbo].[t_menu] ([menu_id])
GO
ALTER TABLE [dbo].[t_proc_age_menu_sales] CHECK CONSTRAINT [FK8q3xasa3p70vyvxk9rlhw8qrp]
GO
ALTER TABLE [dbo].[t_proc_age_menu_sales]  WITH CHECK ADD  CONSTRAINT [FKnpw2hpbr06ar29awxtdtgthtl] FOREIGN KEY([store_id])
REFERENCES [dbo].[t_store] ([store_id])
GO
ALTER TABLE [dbo].[t_proc_age_menu_sales] CHECK CONSTRAINT [FKnpw2hpbr06ar29awxtdtgthtl]
GO
ALTER TABLE [dbo].[t_proc_sales]  WITH CHECK ADD  CONSTRAINT [FKo6whidpkob9vrqf57vvvk4vhl] FOREIGN KEY([store_id])
REFERENCES [dbo].[t_store] ([store_id])
GO
ALTER TABLE [dbo].[t_proc_sales] CHECK CONSTRAINT [FKo6whidpkob9vrqf57vvvk4vhl]
GO
ALTER TABLE [dbo].[t_review]  WITH CHECK ADD  CONSTRAINT [FK770xtfaptveh04oq864ji9n9e] FOREIGN KEY([user_id])
REFERENCES [dbo].[t_user] ([user_id])
GO
ALTER TABLE [dbo].[t_review] CHECK CONSTRAINT [FK770xtfaptveh04oq864ji9n9e]
GO
ALTER TABLE [dbo].[t_review]  WITH CHECK ADD  CONSTRAINT [FKfcrys799cvwnw9xm187kgjlj4] FOREIGN KEY([order_id])
REFERENCES [dbo].[t_order] ([order_id])
GO
ALTER TABLE [dbo].[t_review] CHECK CONSTRAINT [FKfcrys799cvwnw9xm187kgjlj4]
GO
ALTER TABLE [dbo].[t_store]  WITH CHECK ADD  CONSTRAINT [FKrwscu855vqlf592bj5embfmed] FOREIGN KEY([user_id])
REFERENCES [dbo].[t_user] ([user_id])
GO
ALTER TABLE [dbo].[t_store] CHECK CONSTRAINT [FKrwscu855vqlf592bj5embfmed]
GO
ALTER TABLE [dbo].[t_store_menu_category]  WITH CHECK ADD  CONSTRAINT [FKkrsaule4kig90spv4slaxracs] FOREIGN KEY([store_id])
REFERENCES [dbo].[t_store] ([store_id])
GO
ALTER TABLE [dbo].[t_store_menu_category] CHECK CONSTRAINT [FKkrsaule4kig90spv4slaxracs]
GO
ALTER TABLE [dbo].[t_menu]  WITH CHECK ADD CHECK  (([menu_status]='MENU_DISCONTINUED' OR [menu_status]='MENU_SOLD_OUT' OR [menu_status]='MENU_READY'))
GO
ALTER TABLE [dbo].[t_option_category]  WITH CHECK ADD CHECK  (([option_type]='OPTION_CHECKBOX' OR [option_type]='OPTION_RADIO'))
GO
ALTER TABLE [dbo].[t_order]  WITH CHECK ADD CHECK  (([order_status]='ORDER_DONE' OR [order_status]='ORDER_IN_PROGRESS' OR [order_status]='ORDER_DENIED' OR [order_status]='ORDER_ACCEPTED' OR [order_status]='ORDER_CANCELED' OR [order_status]='ORDER_IN'))
GO
ALTER TABLE [dbo].[t_payment]  WITH CHECK ADD CHECK  (([payment_type]='PAYMENT_ACCOUNT' OR [payment_type]='PAYMENT_CARD'))
GO
ALTER TABLE [dbo].[t_user]  WITH CHECK ADD CHECK  (([user_role]='ROLE_ADMIN' OR [user_role]='ROLE_GENERAL'))
GO
