# 基于prometheus的分布式监控中心

# 摘要


# 基于prometheus的分布式监控中心架构设计




# prometheus的原理

![img.png](images/prometheus.png)

```yaml
# my global config
global:
  scrape_interval:     15s # Set the scrape interval to every 15 seconds. Default is every 1 minute.
  evaluation_interval: 15s # Evaluate rules every 15 seconds. The default is every 1 minute.
  # scrape_timeout is set to the global default (10s).

# Alertmanager configuration
alerting:
  alertmanagers:
  - static_configs:
    - targets:
      # - alertmanager:9093

# Load rules once and periodically evaluate them according to the global 'evaluation_interval'.
rule_files:
  # - "first_rules.yml"
  # - "second_rules.yml"

# A scrape configuration containing exactly one endpoint to scrape:
# Here it's Prometheus itself.

scrape_configs:
  - job_name: prometheus
    static_configs:
      - targets: ['192.168.25.137:9400']
        labels:
          instance: prometheus

  - job_name: linux
    static_configs:
      - targets: ['192.168.25.137:9500']
        labels:
          instance: node

  - job_name: cAdvisor
    static_configs:
      - targets: ['192.168.25.137:9600']
        labels:
          instance: docker
```

# Granfa的实战操作

![img.png](images/Grafana监控页面.png)


![img.png](images/Docker的监控页面.png)

# docker-compse的数据采集

```yaml
version: "3.3"
services:
  grafana:
    image: grafana/grafana
    container_name: grafana
    restart: always
    ports:
      - "3000:3000"
    volumes:
      - /home/xjl/docker/grafana/:/var/lib/grafana
  prometheus:
    image: prom/prometheus
    container_name: prometheus
    hostname: prometheus
    restart: always
    volumes:
      - /home/xjl/docker/prometheus/config/prometheus.yml:/etc/prometheus/prometheus.yml
      - /home/xjl/docker/prometheus/conf/rules:/usr/local/prometheus/rules
      - /home/xjl/docker/prometheus/data/:/prometheus
    command:
      - '--config.file=/etc/prometheus/prometheus.yml'
      - '--storage.tsdb.path=/prometheus'
    ports:
      - "9400:9090"
  node-exporter:
    image: prom/node-exporter
    container_name: node-exporter
    restart: always
    ports:
      - "9500:9100"
  cadvisor:
    image: google/cadvisor
    container_name: cadvisor
    restart: always
    volumes:
      - /:/rootfs:ro
      - /var/run:/var/run:rw
      - /sys:/sys:ro
      - /var/lib/docker/:/var/lib/docker:ro
    ports:
      - "9600:8080"
```

# 全自动化监控设计与设计



# 博文参考




