INSERT INTO client_info (case_id, registration_no, client_name, country, sla, assigned_to, fast_track_status, full_legal_name, registered_number, registered_address, legal_form, country_of_establishment, date_of_incorporation, trading_name)
VALUES ('CASE123', 'REG123', 'Acme Corp', 'UK', '24h', 'Alice', true, 'Acme Corporation Ltd', '12345678', '1 Acme St, London', 'Private Limited', 'UK', '2010-01-01', 'Acme');

INSERT INTO companies_house_data (case_id, full_legal_name, registered_number, registered_address, legal_form, country_of_establishment, date_of_incorporation, trading_name)
VALUES ('CASE123', 'Acme Corporation Ltd', '12345678', '1 Acme St, London', 'Private Limited', 'UK', '2010-01-01', 'Acme');

INSERT INTO customer_system_data (case_id, full_legal_name, registered_number, registered_address, legal_form, country_of_establishment, date_of_incorporation, trading_name)
VALUES ('CASE123', 'Acme Corporation Ltd', '12345678', '2 Acme St, London', 'Private Limited', 'UK', '2010-01-01', 'Acme');