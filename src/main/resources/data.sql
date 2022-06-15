INSERT INTO public.vehicle (id, created_date, last_modified_date, licence_plate) VALUES (1, '2022-06-03 23:52:39.017018', '2022-06-03 23:52:39.017018', '34 TL 34');
INSERT INTO public.delivery_point (dtype, id, created_date, last_modified_date, name, type) VALUES ('TRANSFER_CENTER', 2, '2022-06-03 23:52:55.563912', '2022-06-03 23:52:55.563912', 'Transfer Center', 'TRANSFER_CENTER');
INSERT INTO public.delivery_point (dtype, id, created_date, last_modified_date, name, type) VALUES ('DISTRIBUTION_CENTER', 3, '2022-06-03 23:53:05.263788', '2022-06-03 23:53:05.263788', 'Distribution Center', 'DISTRIBUTION_CENTER');
INSERT INTO public.delivery_point (dtype, id, created_date, last_modified_date, name, type) VALUES ('BRANCH', 4, '2022-06-03 23:53:13.163481', '2022-06-03 23:53:13.163481', 'Branch', 'BRANCH');
INSERT INTO public.bag (id, created_date, last_modified_date, barcode, shipment_status, delivery_point_type) VALUES (5, '2022-06-03 23:54:35.808383', '2022-06-03 23:54:35.808383', 'C725799', 1, 'DISTRIBUTION_CENTER');
INSERT INTO public.bag (id, created_date, last_modified_date, barcode, shipment_status, delivery_point_type) VALUES (6, '2022-06-03 23:54:40.925764', '2022-06-03 23:54:40.925764', 'C725800', 1, 'TRANSFER_CENTER');
INSERT INTO public.pack (id, created_date, last_modified_date, barcode, shipment_status, delivery_point_type, volumetric_weight, bag_id) VALUES (8, '2022-06-03 23:55:17.481923', '2022-06-03 23:55:17.481923', 'P7988000121', 1, 'BRANCH', 5, NULL);
INSERT INTO public.pack (id, created_date, last_modified_date, barcode, shipment_status, delivery_point_type, volumetric_weight, bag_id) VALUES (9, '2022-06-03 23:55:20.007504', '2022-06-03 23:55:20.007504', 'P7988000122', 1, 'BRANCH', 5, NULL);
INSERT INTO public.pack (id, created_date, last_modified_date, barcode, shipment_status, delivery_point_type, volumetric_weight, bag_id) VALUES (10, '2022-06-03 23:55:28.083479', '2022-06-03 23:55:28.083479', 'P7988000123', 1, 'BRANCH', 5, NULL);
INSERT INTO public.pack (id, created_date, last_modified_date, barcode, shipment_status, delivery_point_type, volumetric_weight, bag_id) VALUES (11, '2022-06-03 23:55:38.434243', '2022-06-03 23:55:38.434243', 'P8988000120', 1, 'DISTRIBUTION_CENTER', 5, NULL);
INSERT INTO public.pack (id, created_date, last_modified_date, barcode, shipment_status, delivery_point_type, volumetric_weight, bag_id) VALUES (12, '2022-06-03 23:56:02.802292', '2022-06-03 23:58:20.807962', 'P8988000121', 1, 'DISTRIBUTION_CENTER', 5, NULL);
INSERT INTO public.pack (id, created_date, last_modified_date, barcode, shipment_status, delivery_point_type, volumetric_weight, bag_id) VALUES (13, '2022-06-03 23:56:02.802292', '2022-06-03 23:58:20.807962', 'P8988000122', 2, 'DISTRIBUTION_CENTER', 5, 5);
INSERT INTO public.pack (id, created_date, last_modified_date, barcode, shipment_status, delivery_point_type, volumetric_weight, bag_id) VALUES (14, '2022-06-03 23:55:53.18863', '2022-06-03 23:55:53.18863', 'P8988000123', 1, 'DISTRIBUTION_CENTER', 5, NULL);
INSERT INTO public.pack (id, created_date, last_modified_date, barcode, shipment_status, delivery_point_type, volumetric_weight, bag_id) VALUES (15, '2022-06-03 23:55:56.251856', '2022-06-03 23:55:56.251856', 'P8988000124', 1, 'DISTRIBUTION_CENTER', 5, NULL);
INSERT INTO public.pack (id, created_date, last_modified_date, barcode, shipment_status, delivery_point_type, volumetric_weight, bag_id) VALUES (16, '2022-06-03 23:55:59.637879', '2022-06-03 23:55:59.637879', 'P8988000125', 1, 'DISTRIBUTION_CENTER', 5, NULL);
INSERT INTO public.pack (id, created_date, last_modified_date, barcode, shipment_status, delivery_point_type, volumetric_weight, bag_id) VALUES (17, '2022-06-03 23:56:17.568729', '2022-06-03 23:56:17.568729', 'P8988000126', 2, 'DISTRIBUTION_CENTER', 5, 5);
INSERT INTO public.pack (id, created_date, last_modified_date, barcode, shipment_status, delivery_point_type, volumetric_weight, bag_id) VALUES (18, '2022-06-03 23:56:25.06575', '2022-06-03 23:56:25.06575', 'P9988000126', 1, 'TRANSFER_CENTER', 5, NULL);
INSERT INTO public.pack (id, created_date, last_modified_date, barcode, shipment_status, delivery_point_type, volumetric_weight, bag_id) VALUES (19, '2022-06-03 23:56:25.06575', '2022-06-03 23:56:25.06575', 'P9988000127', 1, 'TRANSFER_CENTER', 5, NULL);
INSERT INTO public.pack (id, created_date, last_modified_date, barcode, shipment_status, delivery_point_type, volumetric_weight, bag_id) VALUES (20, '2022-06-03 23:56:27.890214', '2022-06-03 23:58:42.716897', 'P9988000128', 2, 'TRANSFER_CENTER', 5, 6);
INSERT INTO public.pack (id, created_date, last_modified_date, barcode, shipment_status, delivery_point_type, volumetric_weight, bag_id) VALUES (21, '2022-06-03 23:56:31.147277', '2022-06-03 23:58:57.076356', 'P9988000129', 2, 'TRANSFER_CENTER', 5, 6);
INSERT INTO public.pack (id, created_date, last_modified_date, barcode, shipment_status, delivery_point_type, volumetric_weight, bag_id) VALUES (22, '2022-06-03 23:55:10.923149', '2022-06-03 23:55:10.923149', 'P9988000130', 1, 'TRANSFER_CENTER', 5, NULL);