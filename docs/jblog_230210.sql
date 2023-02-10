-- MySQL dump 10.16  Distrib 10.1.48-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: jblog
-- ------------------------------------------------------
-- Server version	10.1.48-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `blog`
--

DROP TABLE IF EXISTS `blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog` (
  `id` varchar(45) NOT NULL,
  `title` varchar(200) NOT NULL,
  `profile` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_blog_user` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog`
--

LOCK TABLES `blog` WRITE;
/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
INSERT INTO `blog` VALUES ('doolly','둘리의 blog','/assets/images/spring-logo.jpg'),('moonyoung','Moonyoung\'s blog','/assets/upload-images/2023110563976.png');
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `id` varchar(45) NOT NULL,
  PRIMARY KEY (`no`),
  KEY `fk_category_blog1` (`id`),
  CONSTRAINT `fk_category_blog1` FOREIGN KEY (`id`) REFERENCES `blog` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (2,'기본','기본카테고리 입니다.','doolly'),(3,'Java','java 카테고리 입니다','moonyoung'),(4,'Spring','Spring 카테고리 입니다','moonyoung'),(5,'HTML','HTML 카테고리 입니다','moonyoung'),(6,'CSS','CSS 카테고리 입니다','moonyoung');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `contents` text NOT NULL,
  `reg_date` datetime DEFAULT NULL,
  `category_no` int(11) NOT NULL,
  PRIMARY KEY (`no`),
  KEY `fk_post_category1` (`category_no`),
  CONSTRAINT `fk_post_category1` FOREIGN KEY (`category_no`) REFERENCES `category` (`no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,'자바(JAVA)란? ','자바는 C언어에 객체 지향적 기능을 추가하여 만든 C++과 달리, 처음부터 객체 지향 언어로 개발된 프로그래밍 언어이다. 자바는 자바 가상 머신(JVM, Java Virtual Machine)을 사용하여 운영체제와 독립적으로 동작할 수 있다. \r\n\r\n따라서 자바는 어느 운영체제에서나 같은 형태로 실행 될 수 있다.','2023-02-10 17:08:57',3),(2,'자바의 특징','1) 객체 지향 프로그래밍(OOP)\r\n2) 자동 메모리 관리(gc)\r\n3) 운영체제에 독립적\r\n4) 멀티쓰레드 지원\r\n5) 동적 로딩 지원','2023-02-10 17:10:43',3),(3,'1. OOP(객체지향언어프로그래밍)  ','⚡ 객체 지향 프로그래밍의 대표적 특징\r\n\r\n1) 상속 (Inheritance) : 부모 클래스의 변수와 메서드를 자식 클래스가 전부 물려받는 것입니다. \r\n2) 캡슐화 (Encapsulation, Information Hiding) : 객체의 변수 및 메서드를 외부 객체가 함부로 건드리지 못하게 감싸는 개념입니다 . 클래스의 getter/setter 등을 통해 은닉합니다. \r\n3) 다형성(Polymorphism)\r\n- Poly(다양한) + morphism(변형,변신) 의 합성어입니다. \r\n- 하나의 객체가 여러가지 타입을 가질 수 있는 것을 의미합니다.\r\n- 자바에서는 한 레퍼런스 변수가 다른 형태의 객체를 참조할 수 있음을 말합니다. \r\n- 오버로딩, 오버라이딩, 업캐스팅, 다운캐스팅 등의 방법이 있습니다.\r\n4) 추상화 (Abstraction) \r\n- 자바에서 공통의 속성, 기능을 묶어 이름을 붙이는 것을 의미합니다. \r\n- 자바에서 추상화는 추상클래스, 인터페이스를 통해 구현됩니다. \r\n- 추상클래스 : 추상메서드를 하나 이상 포함한 추상 클래스 \r\n- 인터페이스 : 추상메서드만을 포함한 추상 클래스, 다중 상속 가능 \r\n* JAVA 8부터는 인터페이스 안에 default 선언을 하면 바디가 있는 메서드도 선언이 가능합니다. ','2023-02-10 17:12:25',3),(4,'2. 자동 메모리 관리','자바에서는 JVM이 지속적으로 메모리를 감시하면서 더이상 사용되지 않는 메모리를 해제시켜 줍니다.\r\n\r\nC/C++ 등 다른 언어의 경우 더이상 사용하지 않는 메모리는 재사용 가능하게 해제해야 합니다. 이는 개발자가 직접 메모리를 해제해야 함을 의미합니다. 그러나 자바는 Garbage Collection을 통해 메모리 관리를 자동으로 수행되기 때문에 개발자가 신경 쓸 필요가 없습니다. 만약 개발자가 직접 메모리를 해제하고 싶은 경우, System.gc();로 Garbage Collector를 호출하여 해제할 수 있습니다. ','2023-02-10 17:13:12',3),(5,'3. 운영체제에 독립적','자바는 운영체제에 독립적입니다. 이것은 무슨의미일까요?\r\n\r\n자바의 개발 환경과 배포환경이 다를 경우, 프로그램을 다시 컴파일 할 필요 없이 실행가능함을 의미합니다. 이는 자바가 Java Virtual Machine 위에서 돌아가기 때문입니다. Java Virtual Machine에서 별도의 Java Compiler를 통해 사용자의 코드를 Byte 코드로 변환합니다. 따라서 모든 자바 프로그램은 이론적으로 CPU나 운영체제의 종류와 무관하게 동일하게 동작합니다. 아래는 Java Virtual Machine 구조입니다. ','2023-02-10 17:14:38',3),(6,'4. 멀티쓰레드 프로그래밍 가능','자바는 하나의 프로그램에서 여러 개의 쓰레드가 동시에 실행할 수 있는 환경을 지원합니다.  C/C++은 운영체제의 도움을 받아 멀티 쓰레드를 수행하지만, 자바는 운영체제 지원없이 멀티스레드 프로그래밍이 가능합니다. \r\n\r\n멀티스레드란? 여러 스레드(프로그램의 실행단위, 프로세스 내 주소공간 및 자원 공유함)를 동시에 실행시키는 응용프로그램을 작성하는 기법입니다. 장점은 프로세스 내 메모리 공유를 통해 시스템 자원 소모가 줄어든다는 점이지만, 반면에 자원을 공유하기 때문에 충돌이 일어날 수 있습니다.','2023-02-10 17:15:06',3),(7,'5. 동적 로딩(Dynamic loading)을 지원','자바는 애플리케이션이 실행될 때 모든 객체가 생성되지 않고,  객체가 필요한 시점에 클래스를 동적 로딩하여 생성합니다.\r\n\r\n동적로딩(Dynamic Loading)은 클래스 일부 변경 시 다시 컴파일하지 않아도 되는 이점이 있습니다.또한, 비교적 적은 작업으로 처리할 수 있는 유연성을  동적로딩이 제공합니다. 반면에 그때 그때 메모리에서 불러오기 때문에 프로그램 실행 속도가 정적로딩에 비해 느립니다. (느린 속도를 해결하기 위해 static 키워드를 사용합니다)\r\n\r\n⚡ 정적 로딩(Static Loading)은 무엇일까요?\r\n\r\n정적 로딩은 프로그램 실행 시 모든 실행파일이 메모리에 적재되어 실행되는 로딩방법입니다. 대표적으로 C언어가 있습니다. 정적로딩은 모든 파일이 메모리에 적재되어 메모리를 많이 차지하지만, 빠르게 가져와 사용할 수 있다는 장단점이 있습니다.','2023-02-10 17:15:40',3),(8,'스프링 이란?','스프링 프레임워크(영어: Spring Framework)는 자바 플랫폼을 위한 오픈 소스 애플리케이션 프레임워크로서 간단히 스프링(Spring)이라고도 한다. 동적인 웹 사이트를 개발하기 위한 여러 가지 서비스를 제공하고 있다. 대한민국 공공기관의 웹 서비스 개발 시 사용을 권장하고 있는 전자정부 표준프레임워크의 기반 기술로서 쓰이고 있다.','2023-02-10 17:50:26',4),(9,'IoC / DI, DL','프로젝트를 진행하면서, 많은 라이브러리를 사용할 것이다.\r\n특정 라이브러리에서 원하는 기능을 사용하려면 new 를 통해서 객체를 생성해야하는데, 이 객체를 생성하기 위해서는 다른 객체를 생성해야하는 등 복잡한 의존 관계가 발생하고 사용자는 파악하기 힘들다.\r\n따라서 스프링 프레임워크는 이러한 객체에 대한 생성과 객체간의 의존관계에 대한 관리를 개발자가 스프링에게 위임하게 된다.\r\n개발자는 스프링이 요구하는 대로 설정만 하면, 설정에 따라서 Bean을 생성하여 컨테이너에 담고 Bean간의 의존관계를 파악(Dependency Look-up)하여 주입 (Dependency Injection)해준다.','2023-02-10 17:52:19',4);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  `join_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('doolly','둘리','*A4B6157319038724E3560894F7F932C8886EBFCF','2023-02-10 17:06:08'),('moonyoung','조문영','*A4B6157319038724E3560894F7F932C8886EBFCF','2023-02-10 17:05:55');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-10 18:01:33
